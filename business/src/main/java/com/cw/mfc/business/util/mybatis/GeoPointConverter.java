package com.cw.mfc.business.util.mybatis;

import com.vividsolutions.jts.geom.*;
import com.vividsolutions.jts.geom.impl.CoordinateArraySequence;
import com.vividsolutions.jts.geom.impl.CoordinateArraySequenceFactory;
import com.vividsolutions.jts.io.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.math.BigDecimal;

/**
 * 地理空间转化工具
 *
 * @author 7788
 */
public class GeoPointConverter {

    /**
     * Little endian or Big endian
     */
    private int byteOrder = ByteOrderValues.LITTLE_ENDIAN;
    /**
     * Precision model
     */
    private PrecisionModel precisionModel = new PrecisionModel();
    /**
     * Coordinate sequence factory
     */
    private CoordinateSequenceFactory coordinateSequenceFactory = CoordinateArraySequenceFactory.instance();
    /**
     * Output dimension
     */
    private int outputDimension = 2;

    /**
     * Convert byte array containing SRID + WKB Geometry into Geometry object
     */
    public GeoPoint from(byte[] bytes) {
        if (bytes == null) {
            return null;
        }
        try (ByteArrayInputStream inputStream = new ByteArrayInputStream(bytes)) {
            // Read SRID
            byte[] sridBytes = new byte[4];
            inputStream.read(sridBytes);
            int srid = ByteOrderValues.getInt(sridBytes, byteOrder);

            // Prepare Geometry factory
            GeometryFactory geometryFactory = new GeometryFactory(precisionModel, srid, coordinateSequenceFactory);

            // Read Geometry
            WKBReader wkbReader = new WKBReader(geometryFactory);
            Geometry geometry = wkbReader.read(new InputStreamInStream(inputStream));
            Point point = (Point) geometry;
            // convert to GeoPoint
            return new GeoPoint(new BigDecimal(String.valueOf(point.getX())), new BigDecimal(String.valueOf(point.getY())));
        } catch (IOException | ParseException e) {
            throw new IllegalArgumentException(e);
        }
    }

    /**
     * Convert Geometry object into byte array containing SRID + WKB Geometry
     */
    public byte[] to(GeoPoint geoPoint) {
        if (geoPoint == null) {
            return null;
        }
        Coordinate coordinate = new Coordinate(geoPoint.getLat().doubleValue(), geoPoint.getLng().doubleValue());
        CoordinateArraySequence coordinateArraySequence = new CoordinateArraySequence(new Coordinate[]{coordinate}, 2);
        Point point = new Point(coordinateArraySequence, new GeometryFactory());
        try (ByteArrayOutputStream outputStream = new ByteArrayOutputStream()) {
            // Write SRID
            byte[] sridBytes = new byte[4];
            ByteOrderValues.putInt(point.getSRID(), sridBytes, byteOrder);
            outputStream.write(sridBytes);
            // Write Geometry
            WKBWriter wkbWriter = new WKBWriter(outputDimension, byteOrder);
            wkbWriter.write(point, new OutputStreamOutStream(outputStream));
            return outputStream.toByteArray();
        } catch (IOException ioe) {
            throw new IllegalArgumentException(ioe);
        }
    }
}
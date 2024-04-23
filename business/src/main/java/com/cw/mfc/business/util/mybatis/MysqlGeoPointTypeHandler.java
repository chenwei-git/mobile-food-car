package com.cw.mfc.business.util.mybatis;

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedTypes;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * mybatis查询结果集中 mysql的geometry类型映射到GeoPoint对象
 * @author 7788
 */
@MappedTypes(value = {GeoPoint.class})
public class MysqlGeoPointTypeHandler extends BaseTypeHandler<GeoPoint> {

    GeoPointConverter converter = new GeoPointConverter();

    @Override
    public void setNonNullParameter(PreparedStatement ps, int i, GeoPoint parameter, JdbcType jdbcType) throws SQLException {
        ps.setBytes(i, converter.to(parameter));
    }

    @Override
    public GeoPoint getNullableResult(ResultSet rs, String columnName) throws SQLException {
        return converter.from(rs.getBytes(columnName));
    }

    @Override
    public GeoPoint getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
        return converter.from(rs.getBytes(columnIndex));
    }

    @Override
    public GeoPoint getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
        return converter.from(cs.getBytes(columnIndex));
    }
}
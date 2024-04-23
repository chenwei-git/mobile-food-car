package com.cw.mfc.business.util.mybatis;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;

@Getter
@Setter
@ToString
public class GeoPoint {
    /**
     * 经度
     */
    private BigDecimal lng;

    /**
     * 纬度
     */
    private BigDecimal lat;

    public GeoPoint(BigDecimal lng, BigDecimal lat) {
        this.lng = lng;
        this.lat = lat;
    }
}
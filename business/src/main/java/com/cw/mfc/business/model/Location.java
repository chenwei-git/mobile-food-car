package com.cw.mfc.business.model;

import com.cw.mfc.business.util.mybatis.GeoPoint;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
public class Location {
    private Long id;

    private Integer status;

    private String description;

    private GeoPoint coordinates;

    private BigDecimal longitude;

    private BigDecimal latitude;

    private Integer version;

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createTime;

    private String createBy;

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date updateTime;

    private String updateBy;

    private Long isDeleted;
}
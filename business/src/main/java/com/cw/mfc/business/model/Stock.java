package com.cw.mfc.business.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
public class Stock {

    private Long id;

    private Long locationId;

    private Long skuId;

    private Long lotNo;

    private Long applicantId;

    private String skuName;

    private BigDecimal availQty;

    private BigDecimal selledQty;

    private BigDecimal destroyQty;

    private Integer status;

    private Integer version;

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createTime;

    private String createBy;

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date updateTime;

    private String updateBy;

    private Long isDeleted;
}
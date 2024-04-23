package com.cw.mfc.business.model;

import com.cw.mfc.business.constant.enums.ApplyStatusEnum;
import com.cw.mfc.business.constant.enums.OpenStatusEnum;
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
public class LocationApplicant {
    private Long id;

    private Long locationId;

    private String locationDesc;

    private Long applicantId;

    private String facilityType;

    private Long cnn;

    /**
     * 申请状态
     * @see ApplyStatusEnum
     */
    private Integer applyStatus;

    /**
     * 营业状态
     * @see OpenStatusEnum
     */
    private Integer openStatus;

    @JsonFormat(pattern="HH:mm", timezone = "GMT+8")
    private Date openTime;

    @JsonFormat(pattern="HH:mm", timezone = "GMT+8")
    private Date closeTime;

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
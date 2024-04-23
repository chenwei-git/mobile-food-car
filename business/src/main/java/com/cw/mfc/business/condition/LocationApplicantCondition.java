package com.cw.mfc.business.condition;

import com.cw.mfc.business.request.LocationApplicantPageRequest;
import com.cw.mfc.business.util.mybatis.GeoPoint;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Date;

@Getter
@Setter
public class LocationApplicantCondition {

    private Long locationId;

    private String locationDesc;

    private Long applicantId;

    private String facilityType;

    private Long cnn;

    private Integer applyStatus;

    private Integer openStatus;

    private Date openTime;

    private Date closeTime;

    private GeoPoint geoPoint;

    private Long distance;

    private String skuName;

    private BigDecimal qty;

    public static LocationApplicantCondition convert(LocationApplicantPageRequest request) {
        LocationApplicantCondition locationApplicantCondition = new LocationApplicantCondition();
        locationApplicantCondition.setLocationId(request.getLocationId());
        locationApplicantCondition.setLocationDesc(request.getLocationDesc());
        locationApplicantCondition.setApplicantId(request.getApplicantId());
        locationApplicantCondition.setFacilityType(request.getFacilityType());
        locationApplicantCondition.setCnn(request.getCnn());
        locationApplicantCondition.setApplyStatus(request.getApplyStatus());
        locationApplicantCondition.setOpenStatus(request.getOpenStatus());
        locationApplicantCondition.setOpenTime(request.getOpenTime());
        locationApplicantCondition.setCloseTime(request.getCloseTime());
        return locationApplicantCondition;
    }
}

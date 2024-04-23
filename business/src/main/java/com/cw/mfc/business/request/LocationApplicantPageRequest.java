package com.cw.mfc.business.request;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
public class LocationApplicantPageRequest extends PageRequest {

    private Long locationId;

    private String locationDesc;

    private Long applicantId;

    private String facilityType;

    private Long cnn;

    private Integer applyStatus;

    private Integer openStatus;

    private Date openTime;

    private Date closeTime;
}

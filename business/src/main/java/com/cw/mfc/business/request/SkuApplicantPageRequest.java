package com.cw.mfc.business.request;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class SkuApplicantPageRequest extends PageRequest {
    private String name;
    private String code;
    private String applicantId;
}

package com.cw.mfc.business.request;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ApplicantPageRequest extends PageRequest {
    private Integer status;
    private String name;
}

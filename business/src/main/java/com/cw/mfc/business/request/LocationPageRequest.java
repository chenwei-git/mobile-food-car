package com.cw.mfc.business.request;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class LocationPageRequest extends PageRequest {
    private Integer status;
    private String description;
}

package com.cw.mfc.business.request;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class StockPageRequest extends PageRequest {
    private Long locationId;
    private Long skuId;
    private Long applicantId;
    private String skuName;
    private Integer status;
}

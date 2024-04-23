package com.cw.mfc.business.condition;

import com.cw.mfc.business.request.StockPageRequest;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
public class StockCondition {

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

    public static StockCondition convert(StockPageRequest request) {
        StockCondition stockCondition = new StockCondition();
        stockCondition.setLocationId(request.getLocationId());
        stockCondition.setSkuId(request.getSkuId());
        stockCondition.setApplicantId(request.getApplicantId());
        stockCondition.setSkuName(request.getSkuName());
        stockCondition.setStatus(request.getStatus());
        return stockCondition;
    }

}

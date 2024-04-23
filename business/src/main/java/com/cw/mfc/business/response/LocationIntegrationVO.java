package com.cw.mfc.business.response;

import com.cw.mfc.business.util.mybatis.GeoPoint;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class LocationIntegrationVO {
    // 查看附近的营业中的还有我喜欢吃的的早餐车
    // 请求：我的坐标，距离范围 + 营业中状态 => location
    // => sku + qty => location
    // 响应：location坐标 location desc -- sku
    private Long locationId;
    private String locationDesc;
    private GeoPoint coordinates;

    private List<SkuVO> skuList;

    @Getter
    @Setter
    @NoArgsConstructor
    public static class SkuVO {
        private String skuName;
        private BigDecimal qty;
    }
}

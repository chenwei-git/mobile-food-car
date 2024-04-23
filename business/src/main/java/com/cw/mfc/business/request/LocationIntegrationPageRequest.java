package com.cw.mfc.business.request;


import com.cw.mfc.business.util.mybatis.GeoPoint;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
public class LocationIntegrationPageRequest extends PageRequest {
    // 查看附近的营业中的还有我喜欢吃的的早餐车
    // 请求：我的坐标，距离范围 + 营业中状态 => location
    // => sku + qty => location
    @NotNull(message = "坐标不能为空")
    private GeoPoint geoPoint;
    @NotNull(message = "距离不能为空")
    private Long distance; // 单位米
    private String skuName;
    private BigDecimal qty = new BigDecimal("1");

}

package com.cw.mfc.business.service.integration;

import com.cw.mfc.business.request.LocationIntegrationPageRequest;
import com.cw.mfc.business.response.LocationIntegrationVO;
import com.cw.mfc.business.response.PageResponse;

public interface LocationIntegrationService {

    // 查看附近的营业中的还有我喜欢吃的的早餐车
    // 请求：我的坐标，距离范围 + 营业中状态 => location
    // => sku + qty => location
    // 响应：location坐标 location desc -- sku
    PageResponse<LocationIntegrationVO> page(LocationIntegrationPageRequest request);
}

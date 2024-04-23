package com.cw.mfc.business.controller;

import com.cw.mfc.business.request.LocationIntegrationPageRequest;
import com.cw.mfc.business.response.LocationIntegrationVO;
import com.cw.mfc.business.response.PageResponse;
import com.cw.mfc.business.response.Result;
import com.cw.mfc.business.service.integration.LocationIntegrationService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/location-integration")
public class LocationIntegrationController {

    @Resource
    private LocationIntegrationService locationIntegrationService;

    @PostMapping("/page")
    public Result<?> create(@Validated @RequestBody LocationIntegrationPageRequest request) {
        PageResponse<LocationIntegrationVO> response = locationIntegrationService.page(request);
        return Result.ok(response);
    }

}

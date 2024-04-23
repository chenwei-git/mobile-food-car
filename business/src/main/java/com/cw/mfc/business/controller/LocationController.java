package com.cw.mfc.business.controller;

import com.cw.mfc.business.model.Location;
import com.cw.mfc.business.request.LocationPageRequest;
import com.cw.mfc.business.request.LocationQueryRequest;
import com.cw.mfc.business.response.PageResponse;
import com.cw.mfc.business.response.Result;
import com.cw.mfc.business.service.LocationService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/location")
public class LocationController {

    @Resource
    private LocationService locationService;

    @PostMapping("/create")
    public Result<?> create(@Validated @RequestBody Location location) {
        if (locationService.create(location) > 0) {
            return Result.ok();
        }
        return Result.error();
    }

    @PostMapping("/page")
    public Result<PageResponse<Location>> page(@Validated @RequestBody LocationPageRequest request) {
        PageResponse<Location> response = locationService.page(request);
        return Result.ok(response);
    }

    @PostMapping("/query")
    public Result<Location> query(@Validated @RequestBody LocationQueryRequest request) {
        Location location = locationService.query(request);
        return Result.ok(location);
    }

    @PostMapping("/modify")
    public Result<?> modify(@Validated @RequestBody Location location) {
        if (locationService.modify(location) > 0) {
            return Result.ok();
        }
        return Result.error("没有数据修改");
    }
}

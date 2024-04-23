package com.cw.mfc.business.controller;

import com.cw.mfc.business.model.LocationApplicant;
import com.cw.mfc.business.request.LocationApplicantPageRequest;
import com.cw.mfc.business.request.LocationApplicantQueryRequest;
import com.cw.mfc.business.response.PageResponse;
import com.cw.mfc.business.response.Result;
import com.cw.mfc.business.service.LocationApplicantService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/location-applicant")
public class LocationApplicantController {

    @Resource
    private LocationApplicantService service;

    @PostMapping("/create")
    public Result<?> create(@Validated @RequestBody LocationApplicant data) {
        if (service.create(data) > 0) {
            return Result.ok();
        }
        return Result.error();
    }

    @PostMapping("/page")
    public Result<PageResponse<LocationApplicant>> page(@Validated @RequestBody LocationApplicantPageRequest request) {
        PageResponse<LocationApplicant> response = service.page(request);
        return Result.ok(response);
    }

    @PostMapping("/query")
    public Result<LocationApplicant> query(@Validated @RequestBody LocationApplicantQueryRequest request) {
        LocationApplicant data = service.query(request);
        return Result.ok(data);
    }

    @PostMapping("/modify")
    public Result<?> modify(@Validated @RequestBody LocationApplicant locationApplicant) {
        if (service.modify(locationApplicant) > 0) {
            return Result.ok();
        }
        return Result.error("没有数据修改");
    }


}

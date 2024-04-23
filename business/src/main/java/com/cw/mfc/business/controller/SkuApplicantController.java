package com.cw.mfc.business.controller;

import com.cw.mfc.business.model.SkuApplicant;
import com.cw.mfc.business.request.SkuApplicantPageRequest;
import com.cw.mfc.business.request.SkuApplicantQueryRequest;
import com.cw.mfc.business.response.PageResponse;
import com.cw.mfc.business.response.Result;
import com.cw.mfc.business.service.SkuApplicantService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/sku-applicant")
public class SkuApplicantController {

    @Resource
    private SkuApplicantService skuApplicantService;

    @PostMapping("/create")
    public Result<?> create(@Validated @RequestBody SkuApplicant skuApplicant) {
        if (skuApplicantService.create(skuApplicant) > 0) {
            return Result.ok();
        }
        return Result.error();
    }

    @PostMapping("/page")
    public Result<PageResponse<SkuApplicant>> page(@Validated @RequestBody SkuApplicantPageRequest request) {
        PageResponse<SkuApplicant> response = skuApplicantService.page(request);
        return Result.ok(response);
    }

    @PostMapping("/query")
    public Result<SkuApplicant> query(@Validated @RequestBody SkuApplicantQueryRequest request) {
        SkuApplicant applicant = skuApplicantService.query(request);
        return Result.ok(applicant);
    }

    @PostMapping("/modify")
    public Result<?> modify(@Validated @RequestBody SkuApplicant skuApplicant) {
        if (skuApplicantService.modify(skuApplicant) > 0) {
            return Result.ok();
        }
        return Result.error("没有数据修改");
    }
}

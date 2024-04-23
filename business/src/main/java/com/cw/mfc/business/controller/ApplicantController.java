package com.cw.mfc.business.controller;

import com.cw.mfc.business.model.Applicant;
import com.cw.mfc.business.request.ApplicantPageRequest;
import com.cw.mfc.business.request.ApplicantQueryRequest;
import com.cw.mfc.business.response.PageResponse;
import com.cw.mfc.business.response.Result;
import com.cw.mfc.business.service.ApplicantService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/applicant")
public class ApplicantController {

    @Resource
    private ApplicantService applicantService;

    @PostMapping("/create")
    public Result<?> create(@Validated @RequestBody Applicant applicant) {
        if (applicantService.create(applicant) > 0) {
            return Result.ok();
        }
        return Result.error();
    }

    @PostMapping("/page")
    public Result<PageResponse<Applicant>> page(@Validated @RequestBody ApplicantPageRequest request) {
        PageResponse<Applicant> response = applicantService.page(request);
        return Result.ok(response);
    }

    @PostMapping("/query")
    public Result<Applicant> query(@Validated @RequestBody ApplicantQueryRequest request) {
        Applicant applicant = applicantService.query(request);
        return Result.ok(applicant);
    }

    @PostMapping("/modify")
    public Result<?> modify(@Validated @RequestBody Applicant applicant) {
        if (applicantService.modify(applicant) > 0) {
            return Result.ok();
        }
        return Result.error("没有数据修改");
    }
}

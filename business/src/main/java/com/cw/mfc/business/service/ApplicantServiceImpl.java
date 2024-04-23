package com.cw.mfc.business.service;

import com.cw.mfc.business.condition.ApplicantCondition;
import com.cw.mfc.business.constant.enums.ApplyStatusEnum;
import com.cw.mfc.business.mapper.ApplicantMapper;
import com.cw.mfc.business.model.Applicant;
import com.cw.mfc.business.request.ApplicantPageRequest;
import com.cw.mfc.business.request.ApplicantQueryRequest;
import com.cw.mfc.business.response.PageResponse;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ApplicantServiceImpl implements ApplicantService {

    @Autowired
    private ApplicantMapper applicantMapper;

    @Override
    public int create(Applicant record) {
        record.setStatus(ApplyStatusEnum.INIT.getCode());
        return applicantMapper.insertSelective(record);
    }


    @Override
    public PageResponse<Applicant> page(ApplicantPageRequest request) {
        PageHelper.startPage(request.getPageNum(), request.getPageSize());
        ApplicantCondition condition = new ApplicantCondition();
        condition.setName(request.getName());
        condition.setStatus(request.getStatus());
        List<Applicant> applicants = applicantMapper.selectByCondition(condition);
        PageInfo<Applicant> pageInfo = new PageInfo<>(applicants);
        PageResponse<Applicant> response = new PageResponse<>();
        response.setTotal(pageInfo.getTotal());
        response.setList(applicants);
        return response;
    }

    @Override
    public Applicant query(ApplicantQueryRequest request) {
        return applicantMapper.selectByPrimaryKey(request.getId());
    }

    @Override
    public int modify(Applicant applicant) {
        return applicantMapper.updateByPrimaryKeySelective(applicant);
    }


}

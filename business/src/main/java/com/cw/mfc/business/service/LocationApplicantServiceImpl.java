package com.cw.mfc.business.service;

import com.cw.mfc.business.condition.LocationApplicantCondition;
import com.cw.mfc.business.constant.enums.ApplyStatusEnum;
import com.cw.mfc.business.constant.enums.OpenStatusEnum;
import com.cw.mfc.business.mapper.LocationApplicantMapper;
import com.cw.mfc.business.model.LocationApplicant;
import com.cw.mfc.business.request.LocationApplicantPageRequest;
import com.cw.mfc.business.request.LocationApplicantQueryRequest;
import com.cw.mfc.business.response.PageResponse;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class LocationApplicantServiceImpl implements LocationApplicantService {

    @Resource
    private LocationApplicantMapper locationApplicantMapper;

    @Override
    public int create(LocationApplicant data) {
        data.setApplyStatus(ApplyStatusEnum.INIT.getCode());
        data.setOpenStatus(OpenStatusEnum.CLOSE.getCode());
        return locationApplicantMapper.insertSelective(data);
    }

    @Override
    public PageResponse<LocationApplicant> page(LocationApplicantPageRequest request) {
        PageHelper.startPage(request.getPageNum(), request.getPageSize());
        LocationApplicantCondition condition = LocationApplicantCondition.convert(request);
        List<LocationApplicant> list = locationApplicantMapper.selectByCondition(condition);
        PageInfo<LocationApplicant> pageInfo = new PageInfo<>(list);
        PageResponse<LocationApplicant> response = new PageResponse<>();
        response.setTotal(pageInfo.getTotal());
        response.setList(list);
        return response;
    }

    @Override
    public LocationApplicant query(LocationApplicantQueryRequest request) {
        return locationApplicantMapper.selectByPrimaryKey(request.getId());
    }

    @Override
    public int modify(LocationApplicant locationApplicant) {
        return locationApplicantMapper.updateByPrimaryKeySelective(locationApplicant);
    }

}

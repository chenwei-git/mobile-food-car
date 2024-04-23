package com.cw.mfc.business.service;

import com.cw.mfc.business.condition.LocationCondition;
import com.cw.mfc.business.constant.enums.LocationStatusEnum;
import com.cw.mfc.business.mapper.LocationMapper;
import com.cw.mfc.business.model.Location;
import com.cw.mfc.business.request.LocationPageRequest;
import com.cw.mfc.business.request.LocationQueryRequest;
import com.cw.mfc.business.response.PageResponse;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class LocationServiceImpl implements LocationService{

    @Autowired
    private LocationMapper locationMapper;

    @Override
    public int create(Location location) {
        location.setStatus(LocationStatusEnum.FREE.getCode());
        return locationMapper.insertSelective(location);
    }

    @Override
    public PageResponse<Location> page(LocationPageRequest request) {
        PageHelper.startPage(request.getPageNum(), request.getPageSize());
        LocationCondition condition = new LocationCondition();
        condition.setDescription(request.getDescription());
        condition.setStatus(request.getStatus());
        List<Location> list = locationMapper.selectByCondition(condition);
        PageInfo<Location> pageInfo = new PageInfo<>(list);
        PageResponse<Location> response = new PageResponse<>();
        response.setTotal(pageInfo.getTotal());
        response.setList(list);
        return response;
    }

    @Override
    public Location query(LocationQueryRequest request) {
        return locationMapper.selectByPrimaryKey(request.getId());
    }

    @Override
    public int modify(Location location) {
        return locationMapper.updateByPrimaryKeySelective(location);
    }

}

package com.cw.mfc.business.service.integration;

import com.cw.mfc.business.condition.LocationApplicantCondition;
import com.cw.mfc.business.constant.enums.OpenStatusEnum;
import com.cw.mfc.business.mapper.LocationApplicantMapper;
import com.cw.mfc.business.mapper.StockMapper;
import com.cw.mfc.business.model.LocationApplicant;
import com.cw.mfc.business.model.Stock;
import com.cw.mfc.business.request.LocationIntegrationPageRequest;
import com.cw.mfc.business.response.LocationIntegrationVO;
import com.cw.mfc.business.response.PageResponse;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class LocationIntegrationServiceImpl implements LocationIntegrationService {

    @Resource
    private LocationApplicantMapper locationApplicantMapper;
    @Resource
    private StockMapper stockMapper;

    @Override
    public PageResponse<LocationIntegrationVO> page(LocationIntegrationPageRequest request) {
        // 查看附近的营业中的还有我喜欢吃的的早餐车
        // 请求：我的坐标，距离范围 + 营业中状态 => location
        // => sku + qty => location
        LocationApplicantCondition condition = new LocationApplicantCondition();
        condition.setGeoPoint(request.getGeoPoint());
        condition.setDistance(request.getDistance());
        condition.setOpenStatus(OpenStatusEnum.OPEN.getCode());
        condition.setSkuName(request.getSkuName());
        condition.setQty(request.getQty());

        PageHelper.startPage(request.getPageNum(), request.getPageSize());
        List<LocationApplicant> locationApplicants = locationApplicantMapper.selectIntegration(condition);

        if (CollectionUtils.isEmpty(locationApplicants)) {
            PageResponse<LocationIntegrationVO> response = new PageResponse<>();
            response.setTotal(0L);
            return response;
        }

        List<Long> locationIdList = locationApplicants.stream()
                .map(LocationApplicant::getLocationId).collect(Collectors.toList());

        List<Stock> stocks = stockMapper.selectByParam(
                locationIdList, request.getSkuName(), request.getQty());

        Map<String, List<Stock>> stockMap = stocks.stream()
                .collect(Collectors.groupingBy(e -> e.getLocationId() + "," + e.getApplicantId()));

        List<LocationIntegrationVO> list = locationApplicants.stream().map(e -> {
            LocationIntegrationVO vo = new LocationIntegrationVO();
            vo.setLocationId(e.getLocationId());
            vo.setLocationDesc(e.getLocationDesc());
            vo.setCoordinates(e.getCoordinates());
            List<Stock> stkList = stockMap.getOrDefault(
                    e.getLocationId() + "," + e.getApplicantId(), new ArrayList<>());
            List<LocationIntegrationVO.SkuVO> skuVOList = stkList.stream().map(x ->
                    {
                        LocationIntegrationVO.SkuVO skuVO = new LocationIntegrationVO.SkuVO();
                        skuVO.setSkuName(x.getSkuName());
                        skuVO.setQty(x.getAvailQty());
                        return skuVO;
                    }
            ).collect(Collectors.toList());
            vo.setSkuList(skuVOList);
            return vo;
        }).toList();

        PageInfo<LocationApplicant> pageInfo = PageInfo.of(locationApplicants);
        PageResponse<LocationIntegrationVO> response = new PageResponse<>();
        response.setTotal(pageInfo.getTotal());
        response.setList(list);
        return response;
    }
}

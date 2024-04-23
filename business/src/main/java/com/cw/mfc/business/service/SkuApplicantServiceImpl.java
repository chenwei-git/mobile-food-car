package com.cw.mfc.business.service;

import com.cw.mfc.business.condition.SkuApplicantCondition;
import com.cw.mfc.business.mapper.SkuApplicantMapper;
import com.cw.mfc.business.model.SkuApplicant;
import com.cw.mfc.business.request.SkuApplicantPageRequest;
import com.cw.mfc.business.request.SkuApplicantQueryRequest;
import com.cw.mfc.business.response.PageResponse;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class SkuApplicantServiceImpl implements SkuApplicantService {

    @Resource
    private SkuApplicantMapper skuApplicantMapper;

    @Override
    public int deleteByPrimaryKey(Long id) {
        return skuApplicantMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(SkuApplicant record) {
        return skuApplicantMapper.insert(record);
    }

    @Override
    public int insertSelective(SkuApplicant record) {
        return skuApplicantMapper.insertSelective(record);
    }

    @Override
    public SkuApplicant selectByPrimaryKey(Long id) {
        return skuApplicantMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(SkuApplicant record) {
        return skuApplicantMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(SkuApplicant record) {
        return skuApplicantMapper.updateByPrimaryKey(record);
    }

    @Override
    public int batchInsert(List<SkuApplicant> list) {
        return skuApplicantMapper.batchInsert(list);
    }

    @Override
    public int create(SkuApplicant skuApplicant) {
        return skuApplicantMapper.insertSelective(skuApplicant);
    }

    @Override
    public PageResponse<SkuApplicant> page(SkuApplicantPageRequest request) {
        PageHelper.startPage(request.getPageNum(), request.getPageSize());
        SkuApplicantCondition condition = SkuApplicantCondition.convert(request);
        List<SkuApplicant> list = skuApplicantMapper.selectByCondition(condition);
        PageInfo<SkuApplicant> pageInfo = new PageInfo<>(list);
        PageResponse<SkuApplicant> pageResponse = new PageResponse<>();
        pageResponse.setTotal(pageInfo.getTotal());
        pageResponse.setList(list);
        return pageResponse;
    }

    @Override
    public SkuApplicant query(SkuApplicantQueryRequest request) {
        return skuApplicantMapper.selectByPrimaryKey(request.getId());
    }

    @Override
    public int modify(SkuApplicant skuApplicant) {
        return skuApplicantMapper.updateByPrimaryKeySelective(skuApplicant);
    }

}

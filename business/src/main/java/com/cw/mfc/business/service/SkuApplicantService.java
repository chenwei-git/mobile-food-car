package com.cw.mfc.business.service;

import com.cw.mfc.business.model.SkuApplicant;
import com.cw.mfc.business.request.SkuApplicantPageRequest;
import com.cw.mfc.business.request.SkuApplicantQueryRequest;
import com.cw.mfc.business.response.PageResponse;

import java.util.List;
public interface SkuApplicantService{

    int deleteByPrimaryKey(Long id);

    int insert(SkuApplicant record);

    int insertSelective(SkuApplicant record);

    SkuApplicant selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(SkuApplicant record);

    int updateByPrimaryKey(SkuApplicant record);

    int batchInsert(List<SkuApplicant> list);

    int create(SkuApplicant skuApplicant);

    PageResponse<SkuApplicant> page(SkuApplicantPageRequest request);

    SkuApplicant query(SkuApplicantQueryRequest request);

    int modify(SkuApplicant skuApplicant);
}

package com.cw.mfc.business.mapper;

import com.cw.mfc.business.condition.SkuApplicantCondition;
import com.cw.mfc.business.model.SkuApplicant;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SkuApplicantMapper {

    int deleteByPrimaryKey(Long id);

    int insert(SkuApplicant record);

    int insertSelective(SkuApplicant record);

    SkuApplicant selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(SkuApplicant record);

    int updateByPrimaryKey(SkuApplicant record);

    int batchInsert(@Param("list") List<SkuApplicant> list);

    List<SkuApplicant> selectByCondition(@Param("condition") SkuApplicantCondition condition);
}
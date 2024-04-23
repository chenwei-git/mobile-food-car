package com.cw.mfc.business.mapper;

import com.cw.mfc.business.condition.LocationApplicantCondition;
import com.cw.mfc.business.model.LocationApplicant;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface LocationApplicantMapper {

    int deleteByPrimaryKey(Long id);

    int insert(LocationApplicant record);

    int insertSelective(LocationApplicant record);

    LocationApplicant selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(LocationApplicant record);

    int updateByPrimaryKey(LocationApplicant record);

    List<LocationApplicant> selectByCondition(@Param("condition") LocationApplicantCondition condition);

    List<LocationApplicant> selectIntegration(@Param("condition") LocationApplicantCondition condition);
}
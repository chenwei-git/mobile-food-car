package com.cw.mfc.business.mapper;

import com.cw.mfc.business.condition.ApplicantCondition;
import com.cw.mfc.business.model.Applicant;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ApplicantMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Applicant record);

    int insertSelective(Applicant record);

    Applicant selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Applicant record);

    int updateByPrimaryKey(Applicant record);

    int batchInsert(@Param("list") List<Applicant> list);

    List<Applicant> selectByCondition(@Param("condition") ApplicantCondition condition);
}
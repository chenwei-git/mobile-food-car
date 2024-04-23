package com.cw.mfc.business.mapper;

import com.cw.mfc.business.condition.LocationCondition;
import com.cw.mfc.business.model.Location;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface LocationMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Location record);

    int insertSelective(Location record);

    Location selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Location record);

    int updateByPrimaryKey(Location record);

    int batchInsert(@Param("list") List<Location> list);

    List<Location> selectByCondition(@Param("condition") LocationCondition condition);
}
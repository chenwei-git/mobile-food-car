package com.cw.mfc.business.mapper;

import com.cw.mfc.business.condition.StockCondition;
import com.cw.mfc.business.model.Stock;
import org.apache.ibatis.annotations.Param;

import java.math.BigDecimal;
import java.util.List;

public interface StockMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Stock record);

    int insertSelective(Stock record);

    Stock selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Stock record);

    int updateByPrimaryKey(Stock record);

    int batchInsert(@Param("list") List<Stock> list);

    List<Stock> selectByParam(@Param("locationIds") List<Long> locationIds,
                              @Param("skuName") String skuName, @Param("qty") BigDecimal qty);

    List<Stock> selectByCondition(@Param("condition") StockCondition stockCondition);
}
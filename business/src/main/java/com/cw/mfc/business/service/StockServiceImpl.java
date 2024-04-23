package com.cw.mfc.business.service;

import com.cw.mfc.business.condition.StockCondition;
import com.cw.mfc.business.constant.enums.SellStatusEnum;
import com.cw.mfc.business.mapper.SkuApplicantMapper;
import com.cw.mfc.business.mapper.StockMapper;
import com.cw.mfc.business.model.SkuApplicant;
import com.cw.mfc.business.model.Stock;
import com.cw.mfc.business.request.StockPageRequest;
import com.cw.mfc.business.request.StockQueryRequest;
import com.cw.mfc.business.response.PageResponse;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.List;

@Service
public class StockServiceImpl implements StockService {


    @Resource
    private StockMapper stockMapper;
    @Resource
    private SkuApplicantMapper skuApplicantMapper;

    @Override
    public int create(Stock stock) {

        StockCondition condition = new StockCondition();
        condition.setLocationId(stock.getLocationId());
        condition.setApplicantId(stock.getApplicantId());
        condition.setSkuId(stock.getSkuId());
        condition.setLotNo(stock.getLotNo());
        List<Stock> stocks = stockMapper.selectByCondition(condition);
        if (!CollectionUtils.isEmpty(stocks)) {
            throw new RuntimeException("该商品库存已存在，请去修改");
        }

        SkuApplicant skuApplicant = skuApplicantMapper.selectByPrimaryKey(stock.getSkuId());
        stock.setSkuName(skuApplicant.getName());
        stock.setStatus(SellStatusEnum.AVAIL.getCode());
        return stockMapper.insertSelective(stock);
    }

    @Override
    public PageResponse<Stock> page(StockPageRequest request) {
        StockCondition condition = StockCondition.convert(request);
        List<Stock> stocks = stockMapper.selectByCondition(condition);
        PageInfo<Stock> pageInfo = new PageInfo<>(stocks);
        PageResponse<Stock> pageResponse = new PageResponse<>();
        pageResponse.setTotal(pageInfo.getTotal());
        pageResponse.setList(stocks);
        return pageResponse;
    }

    @Override
    public Stock query(StockQueryRequest request) {
        return stockMapper.selectByPrimaryKey(request.getId());
    }

    @Override
    public int modify(Stock stock) {
        StockCondition condition = new StockCondition();
        condition.setLocationId(stock.getLocationId());
        condition.setApplicantId(stock.getApplicantId());
        condition.setSkuId(stock.getSkuId());
        condition.setLotNo(stock.getLotNo());
        List<Stock> stocks = stockMapper.selectByCondition(condition);
        if (!CollectionUtils.isEmpty(stocks)) {
            throw new RuntimeException("该商品库存不存在，请添加");
        }
        if (stock.getAvailQty() != null) {
            BigDecimal availQty = stocks.get(0).getAvailQty();
            stock.setAvailQty(stock.getAvailQty().add(availQty));
        }
        return stockMapper.updateByPrimaryKeySelective(stock);
    }

}

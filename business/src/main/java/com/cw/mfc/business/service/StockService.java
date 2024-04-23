package com.cw.mfc.business.service;

import com.cw.mfc.business.model.Stock;
import com.cw.mfc.business.request.StockPageRequest;
import com.cw.mfc.business.request.StockQueryRequest;
import com.cw.mfc.business.response.PageResponse;
public interface StockService{

    int create(Stock stock);

    PageResponse<Stock> page(StockPageRequest request);

    Stock query(StockQueryRequest request);

    int modify(Stock stock);
}

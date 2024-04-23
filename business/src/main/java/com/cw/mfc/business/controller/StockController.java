package com.cw.mfc.business.controller;

import com.cw.mfc.business.model.Stock;
import com.cw.mfc.business.request.StockPageRequest;
import com.cw.mfc.business.request.StockQueryRequest;
import com.cw.mfc.business.response.PageResponse;
import com.cw.mfc.business.response.Result;
import com.cw.mfc.business.service.StockService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/stock")
public class StockController {

    @Resource
    private StockService stockService;

    @PostMapping("/create")
    public Result<?> create(@Validated @RequestBody Stock stock) {
        if (stockService.create(stock) > 0) {
            return Result.ok();
        }
        return Result.error();
    }

    @PostMapping("/page")
    public Result<PageResponse<Stock>> page(@Validated @RequestBody StockPageRequest request) {
        PageResponse<Stock> response = stockService.page(request);
        return Result.ok(response);
    }

    @PostMapping("/query")
    public Result<Stock> query(@Validated @RequestBody StockQueryRequest request) {
        Stock stock = stockService.query(request);
        return Result.ok(stock);
    }

    @PostMapping("/modify")
    public Result<?> modify(@Validated @RequestBody Stock stock) {
        if (stockService.modify(stock) > 0) {
            return Result.ok();
        }
        return Result.error("没有数据修改");
    }
}

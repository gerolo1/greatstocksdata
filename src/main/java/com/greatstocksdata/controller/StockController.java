package com.greatstocksdata.controller;

import com.greatstocksdata.model.dto.ConditionStock;
import com.greatstocksdata.model.dto.StockResponse;
import com.greatstocksdata.service.StockService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/stocks")
@AllArgsConstructor
public class StockController {

    private final StockService stockService;

    @GetMapping("/bests")
    public ResponseEntity<List<StockResponse>> getBestStocks(@RequestHeader String apiKey) {
        return stockService.getStocks(ConditionStock.BEST, apiKey);
    }

    @GetMapping("/worsts")
    public ResponseEntity<List<StockResponse>> getWorstStocks(@RequestHeader String apiKey) {
        return stockService.getStocks(ConditionStock.WORST, apiKey);
    }
}

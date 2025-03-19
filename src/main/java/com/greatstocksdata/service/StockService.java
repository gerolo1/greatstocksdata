package com.greatstocksdata.service;

import com.greatstocksdata.model.dto.ConditionStock;
import com.greatstocksdata.model.dto.StockResponse;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface StockService {

    ResponseEntity<List<StockResponse>> getStocks(ConditionStock conditionStock, String apiKey);
}

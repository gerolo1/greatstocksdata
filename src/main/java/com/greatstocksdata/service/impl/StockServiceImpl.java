package com.greatstocksdata.service.impl;

import com.greatstocksdata.model.dto.*;
import com.greatstocksdata.service.StockService;
import com.greatstocksdata.utils.StockUtils;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
@Log4j2
public class StockServiceImpl implements StockService {

    private final StockUtils stockUtils;

    @Override
    public ResponseEntity<List<StockResponse>> getStocks(ConditionStock conditionStock, String apiKey) {
        log.info("INIT: StockServiceImpl - getStocks");

        TrendingsResponse trendingsResponse = stockUtils.getTrendings(apiKey);

        List<StockResponse> listStock = new ArrayList<>();

        for(int i=0; i<10; i++) {
            TrendingObjectResponse trendingObject = conditionStock.equals(ConditionStock.BEST)
                    ? trendingsResponse.getTopGainers().get(i)
                    : trendingsResponse.getTopLosers().get(i);

            StockResponse stockResponse = new StockResponse();

            stockResponse.setSymbol(trendingObject.getTicker());
            stockResponse.setPrice(trendingObject.getPrice());
            stockResponse.setChangePercentage(trendingObject.getChangePercentage());

            OverviewResponse overviewResponse = stockUtils.getOverview(trendingObject.getTicker(), apiKey);

            stockResponse.setName(overviewResponse.getName());
            stockResponse.setDescription(overviewResponse.getDescription());
            stockResponse.setCountry(overviewResponse.getCountry());
            stockResponse.setCurrency(overviewResponse.getCurrency());
            stockResponse.setExchange(overviewResponse.getExchange());
            stockResponse.setIndustry(overviewResponse.getIndustry() + " - " + overviewResponse.getSector());
            stockResponse.setType(overviewResponse.getAssetType());
            stockResponse.setDividendPerShare(overviewResponse.getDividendPerShare());

            listStock.add(stockResponse);
        }

        log.info("END: StockServiceImpl - getStocks");
        return ResponseEntity.status(HttpStatus.OK).body(listStock);
    }
}

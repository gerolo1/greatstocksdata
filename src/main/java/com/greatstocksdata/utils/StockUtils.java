package com.greatstocksdata.utils;

import com.greatstocksdata.model.dto.OverviewResponse;
import com.greatstocksdata.model.dto.TrendingsResponse;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;

@Component
@AllArgsConstructor
@Log4j2
public class StockUtils {

    private final RestClient restClient;

    public TrendingsResponse getTrendings(String apiKey) {

        ResponseEntity<TrendingsResponse> response = restClient.get()
                .uri(uriBuilder -> uriBuilder
                        .path("/query")
                        .queryParam("function", "TOP_GAINERS_LOSERS")
                        .queryParam("apikey", apiKey)
                        .build())
                .retrieve()
                .toEntity(TrendingsResponse.class);

        log.info(response.getBody());

        return response.getBody();
    }

    public OverviewResponse getOverview(String symbol, String apiKey) {

        ResponseEntity<OverviewResponse> response = restClient.get()
                .uri(uriBuilder -> uriBuilder
                        .path("/query")
                        .queryParam("function", "OVERVIEW")
                        .queryParam("symbol", symbol)
                        .queryParam("apikey", apiKey)
                        .build())
                .retrieve()
                .toEntity(OverviewResponse.class);

        log.info(response.getBody());

        return response.getBody();
    }
}

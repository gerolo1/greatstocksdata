package com.greatstocksdata.model.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class StockResponse {

    String symbol;

    String name;

    String type;

    String description;

    String exchange;

    String currency;

    String country;

    String industry;

    String changePercentage;

    BigDecimal price;

    String dividendPerShare;
}

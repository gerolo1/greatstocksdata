package com.greatstocksdata.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class OverviewResponse {

    @JsonProperty("Symbol")
    String symbol;

    @JsonProperty("Name")
    String name;

    @JsonProperty("AssetType")
    String assetType;

    @JsonProperty("Description")
    String description;

    @JsonProperty("Exchange")
    String exchange;

    @JsonProperty("Currency")
    String currency;

    @JsonProperty("Country")
    String country;

    @JsonProperty("Sector")
    String sector;

    @JsonProperty("Industry")
    String industry;

    @JsonProperty("DividendPerShare")
    String dividendPerShare;
}

package com.greatstocksdata.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class TrendingsResponse implements Serializable {

    private String metadata;

    @JsonProperty("last_updated")
    private String lastUpdated;

    @JsonProperty("top_gainers")
    private List<TrendingObjectResponse> topGainers;

    @JsonProperty("top_losers")
    private List<TrendingObjectResponse> topLosers;

    @JsonProperty("most_actively_traded")
    private List<TrendingObjectResponse> mostActivelyTraded;
}

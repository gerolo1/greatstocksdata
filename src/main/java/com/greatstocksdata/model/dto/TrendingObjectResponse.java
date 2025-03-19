package com.greatstocksdata.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
public class TrendingObjectResponse implements Serializable {

    private String ticker;

    private BigDecimal price;

    @JsonProperty("change_amount")
    private BigDecimal changeAmount;

    @JsonProperty("change_percentage")
    private String changePercentage;

    private BigDecimal volume;
}

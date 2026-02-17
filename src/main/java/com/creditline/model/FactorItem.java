package com.creditline.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.fasterxml.jackson.annotation.JsonProperty;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FactorItem {
    @JsonProperty("factor")
    private double factor;
    @JsonProperty("factorType")
    private String factorType;
}
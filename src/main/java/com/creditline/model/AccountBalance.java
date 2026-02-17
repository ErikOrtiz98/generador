package com.creditline.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.fasterxml.jackson.annotation.JsonProperty;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AccountBalance {
    @JsonProperty("accountBalance")
    private double accountBalance;
    @JsonProperty("accountBalanceType")
    private String accountBalanceType;
}
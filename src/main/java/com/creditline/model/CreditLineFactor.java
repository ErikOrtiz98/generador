package com.creditline.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreditLineFactor {
    @JsonAlias("factor-item")
    private List<FactorItem> factorItem;
}

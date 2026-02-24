package com.creditline.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreditLineFacilityRequest {
    private Party party;
    private MerchantReference merchantReference;
    private java.util.List<Location> location;
}

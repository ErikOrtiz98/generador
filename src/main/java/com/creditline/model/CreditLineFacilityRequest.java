package com.creditline.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreditLineFacilityRequest {
    private CreditLineFacility creditLineFacility;
    private CreditProfile creditProfile;
    private List<AccountBalance> accountBalance;
    private List<CreditLineFactor> creditLineFactor;
}
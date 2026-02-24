package com.creditline.dto;

import com.creditline.model.CreditLineFacilityResponse;
import com.creditline.model.CreditProfile;
import com.creditline.model.AccountBalance;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseData {
    private CreditLineFacilityResponse creditLineFacility;
    private CreditProfile creditProfile;
    private List<AccountBalance> accountBalance;
}

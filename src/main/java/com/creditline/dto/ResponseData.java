package com.creditline.dto;

import com.creditline.model.CreditLineFacilityResponse;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseData {
    private CreditLineFacilityResponse creditLineFacility;
}
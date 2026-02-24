package com.creditline.service;

import com.creditline.dto.ApiResponse;
import com.creditline.dto.ResponseData;
import com.creditline.dto.ResponseMeta;
import com.creditline.model.CreditLineFacilityRequest;
import com.creditline.model.CreditLineFacilityResponse;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

@Service
public class CreditLineService {

    public ApiResponse calculateCreditLineFacility(CreditLineFacilityRequest request) {
        double creditFacilityAvailableAmount = calculateMargin(request);

        CreditLineFacilityResponse facilityResponse = new CreditLineFacilityResponse();
        facilityResponse.setCreditFacilityAvailableAmount(creditFacilityAvailableAmount);
        facilityResponse.setHasCreditFacility(true);

        ResponseData data = new ResponseData();
        data.setCreditLineFacility(facilityResponse);

        ResponseMeta meta = new ResponseMeta();
        meta.setTransactionID(UUID.randomUUID().toString());
        meta.setStatus("OK");
        meta.setStatusCode(200);
        meta.setTimestamp(getCurrentTimestamp());

        ApiResponse response = new ApiResponse();
        response.setMeta(meta);
        response.setData(data);
        return response;
    }

    private double calculateMargin(CreditLineFacilityRequest request) {
        validateRequest(request);
        int merchantId = request.getMerchantReference().getMerchantId();
        int cityCode = Integer.parseInt(request.getLocation().get(0).getCity().getCode());
        return merchantId * cityCode;
    }

    private void validateRequest(CreditLineFacilityRequest request) {
        if (request == null
                || request.getParty() == null
                || request.getParty().getPartyID() == null
                || request.getParty().getPartyID().isBlank()
                || request.getMerchantReference() == null
                || request.getLocation() == null
                || request.getLocation().isEmpty()
                || request.getLocation().get(0).getCity() == null
                || request.getLocation().get(0).getCity().getCode() == null
                || request.getLocation().get(0).getCity().getCode().isBlank()) {
            throw new IllegalArgumentException("Invalid request payload: missing required fields for calculation");
        }
    }

    private String getCurrentTimestamp() {
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSSSSSSSS");
        return now.format(formatter);
    }
}

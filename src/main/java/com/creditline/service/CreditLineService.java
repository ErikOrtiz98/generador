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
        // Calcular el margen de la facilidad de crédito
        double creditFacilityAvailableAmount = calculateMargin(request);

        CreditLineFacilityResponse facilityResponse = new CreditLineFacilityResponse();
        facilityResponse.setCreditFacilityAvailableAmount(creditFacilityAvailableAmount);
        facilityResponse.setHasCreditFacility(false);

        ResponseData data = new ResponseData();
        data.setCreditLineFacility(facilityResponse);
        data.setCreditProfile(request.getCreditProfile());
        data.setAccountBalance(request.getAccountBalance());

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

        double baseAmount = request.getCreditProfile().getCreditLine();
        double minimumSalary = request.getCreditLineFacility().getMinimumSalaryRequired();
        double numberOfSalaries = request.getCreditLineFacility().getNumberOfMinimumSalary();
        double accountBalance = request.getAccountBalance().get(0).getAccountBalance();
        double factor = request.getCreditLineFactor().get(0).getFactorItem().get(0).getFactor();

        // Fórmula de cálculo: creditLine * (numberOfMinimumSalary / minimumSalaryRequired) * factor + accountBalance
        return (baseAmount * (numberOfSalaries / minimumSalary) * (factor / 100)) + accountBalance;
    }

    private void validateRequest(CreditLineFacilityRequest request) {
        if (request == null
                || request.getCreditLineFacility() == null
                || request.getCreditProfile() == null
                || request.getAccountBalance() == null
                || request.getAccountBalance().isEmpty()
                || request.getCreditLineFactor() == null
                || request.getCreditLineFactor().isEmpty()
                || request.getCreditLineFactor().get(0).getFactorItem() == null
                || request.getCreditLineFactor().get(0).getFactorItem().isEmpty()) {
            throw new IllegalArgumentException("Invalid request payload: missing required fields for calculation");
        }
    }

    private String getCurrentTimestamp() {
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSSSSSSSS");
        return now.format(formatter);
    }

}

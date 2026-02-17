package com.creditline.controller;

import com.creditline.dto.ApiResponse;
import com.creditline.model.CreditLineFacilityRequest;
import com.creditline.service.CreditLineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/credit-line")
@CrossOrigin(origins = "*")
public class CreditLineController {

    @Autowired
    private CreditLineService creditLineService;

    @PostMapping("/calculate")
    public ResponseEntity<ApiResponse> calculateCreditLine(@RequestBody CreditLineFacilityRequest request) {
        try {
            ApiResponse response = creditLineService.calculateCreditLineFacility(request);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
package com.creditline.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreditLineFacility {
    private boolean customerCreditLine;
    private double minimumSalaryRequired;
    private double numberOfMinimumSalary;
}
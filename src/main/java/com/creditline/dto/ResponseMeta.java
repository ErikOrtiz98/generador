package com.creditline.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseMeta {
    private String transactionID;
    private String status;
    private int statusCode;
    private String timestamp;
}
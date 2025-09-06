package com.majeed.cryptoservice.entity.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ApiResponse {
    private boolean success;
    private String message;
    private SuccessDetail successDetail;
    private ErrorDetail error;
}

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SuccessDetail<T> {
    private String code;
    private T data;
}

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ErrorDetail<T> {
    private String code;
    private T data;
}

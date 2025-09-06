package com.majeed.cryptoservice.dto;

import com.majeed.cryptoservice.constants.SuccessCode;

public class SuccessResponseBuilder {
    private SuccessResponseBuilder() {
        // utility class
    }

    public static <T> ApiResponse<T> populate(SuccessCode successCode, T data) {
        return ApiResponse.<T>builder()
                .success(true)
                .message(successCode.getDescription())
                .successDetail(
                        SuccessDetail.<T>builder()
                                .code(successCode.getCode())
                                .data(data)
                                .build()
                )
                .build();
    }

    public static <T> ApiResponse<T> populate(SuccessCode successCode) {
        return populate(successCode, null);
    }
}

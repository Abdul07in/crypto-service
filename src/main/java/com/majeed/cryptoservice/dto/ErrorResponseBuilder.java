package com.majeed.cryptoservice.dto;

import com.majeed.cryptoservice.constants.ErrorCode;

public class ErrorResponseBuilder {
    private ErrorResponseBuilder() {
        // utility class
    }

    public static <T> ApiResponse<T> populate(ErrorCode errorCode, T data) {
        return ApiResponse.<T>builder()
                .success(false)
                .message(errorCode.getDescription())
                .error(
                        ErrorDetail.<T>builder()
                                .code(errorCode.getCode())
                                .data(data)
                                .build()
                )
                .build();
    }

    public static <T> ApiResponse<T> populate(ErrorCode errorCode) {
        return populate(errorCode, null);
    }
}

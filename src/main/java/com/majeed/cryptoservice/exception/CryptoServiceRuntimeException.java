package com.majeed.cryptoservice.exception;

import com.majeed.cryptoservice.constants.ErrorCode;

public class CryptoServiceRuntimeException extends RuntimeException {

    private final ErrorCode errorCode;

    public CryptoServiceRuntimeException(ErrorCode errorCode) {
        super(errorCode.getDescription());
        this.errorCode = errorCode;
    }

    public ErrorCode getErrorCode() {
        return errorCode;
    }

    public String getCode() {
        return errorCode.getCode();
    }
}

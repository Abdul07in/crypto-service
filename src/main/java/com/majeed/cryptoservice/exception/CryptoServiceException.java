package com.majeed.cryptoservice.exception;

import com.majeed.cryptoservice.constants.ErrorCode;
import lombok.Getter;

public class CryptoServiceException extends Exception {

    private final ErrorCode errorCode;

    public CryptoServiceException(ErrorCode errorCode) {
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

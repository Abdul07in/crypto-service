package com.majeed.cryptoservice.constants;

import lombok.Getter;
import org.springframework.http.HttpStatus;


public enum ErrorCode {

    INVALID_INPUT(HttpStatus.BAD_REQUEST, "001", ServiceConstants.INVALID_INPUT),
    ENTITY_NOT_FOUND(HttpStatus.NOT_FOUND, "002", ServiceConstants.USER_NOT_FOUND),
    UNKNOWN_ERROR(HttpStatus.INTERNAL_SERVER_ERROR,"003" , ServiceConstants.SOMETHING_WENT_WRONG);

    @Getter
    private final HttpStatus httpStatus;
    private final String code;
    @Getter
    private final String description;

    ErrorCode(HttpStatus httpStatus, String code, String description) {
        this.httpStatus = httpStatus;
        this.code = code;
        this.description = description;
    }

    public String getCode() {
        return ServiceConstants.ERROR_PREFIX + code;
    }

}

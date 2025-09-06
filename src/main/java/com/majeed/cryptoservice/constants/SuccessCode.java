package com.majeed.cryptoservice.constants;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public enum SuccessCode {

    FETCH_SUCCESS(HttpStatus.OK, "001", ServiceConstants.DATA_FETCHED_SUCCESSFULLY);


    private final HttpStatus httpStatus;
    private final String code;
    private final String description;

    SuccessCode(HttpStatus httpStatus, String code, String description) {
        this.httpStatus = httpStatus;
        this.code = code;
        this.description = description;
    }

    public String getCode() {
        return ServiceConstants.SUCCESS_PREFIX + code;
    }


}

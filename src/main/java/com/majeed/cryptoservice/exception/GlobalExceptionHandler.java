package com.majeed.cryptoservice.exception;

import com.majeed.cryptoservice.constants.ErrorCode;
import com.majeed.cryptoservice.dto.ApiResponse;
import com.majeed.cryptoservice.dto.ErrorDetail;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    // Handle checked exceptions
    @ExceptionHandler(CryptoServiceException.class)
    public ResponseEntity<ApiResponse<?>> handleCryptoServiceException(CryptoServiceException ex) {
        ErrorCode errorCode = ex.getErrorCode();

        return ResponseEntity
                .status(errorCode.getHttpStatus())
                .body(ApiResponse.builder()
                        .success(false)
                        .message(errorCode.getDescription())
                        .error(ErrorDetail.builder()
                                .code(errorCode.getCode())
                                .data(null)
                                .build())
                        .build());
    }

    // Handle runtime exceptions
    @ExceptionHandler(CryptoServiceRuntimeException.class)
    public ResponseEntity<ApiResponse<?>> handleCryptoServiceRuntimeException(CryptoServiceRuntimeException ex) {
        ErrorCode errorCode = ex.getErrorCode();

        return ResponseEntity
                .status(errorCode.getHttpStatus())
                .body(ApiResponse.builder()
                        .success(false)
                        .message(errorCode.getDescription())
                        .error(ErrorDetail.builder()
                                .code(errorCode.getCode())
                                .data(null)
                                .build())
                        .build());
    }

    // Handle validation errors from @Valid DTOs
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ApiResponse<?>> handleValidationException(MethodArgumentNotValidException ex) {
        ErrorCode errorCode = ErrorCode.INVALID_INPUT;

        Map<String, String> fieldErrors = new HashMap<>();
        for (FieldError fieldError : ex.getBindingResult().getFieldErrors()) {
            fieldErrors.put(fieldError.getField(), fieldError.getDefaultMessage());
        }

        return ResponseEntity
                .status(errorCode.getHttpStatus())
                .body(ApiResponse.builder()
                        .success(false)
                        .message("Validation failed")
                        .error(ErrorDetail.builder()
                                .code(errorCode.getCode())
                                .data(fieldErrors) // send field-specific messages
                                .build())
                        .build());
    }

    // Catch-all handler for unexpected exceptions
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiResponse<?>> handleGeneralException(Exception ex) {
        ErrorCode errorCode = ErrorCode.UNKNOWN_ERROR;

        return ResponseEntity
                .status(errorCode.getHttpStatus())
                .body(ApiResponse.builder()
                        .success(false)
                        .message(errorCode.getDescription())
                        .error(ErrorDetail.builder()
                                .code(errorCode.getCode())
                                .data(ex.getMessage()) // expose msg (for dev), can hide in prod
                                .build())
                        .build());
    }
}

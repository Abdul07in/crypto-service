package com.majeed.cryptoservice.controller;

import com.majeed.cryptoservice.constants.ErrorCode;
import com.majeed.cryptoservice.constants.SuccessCode;
import com.majeed.cryptoservice.dto.ApiResponse;
import com.majeed.cryptoservice.dto.SuccessResponseBuilder;
import com.majeed.cryptoservice.exception.CryptoServiceException;
import io.micrometer.common.util.StringUtils;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@AllArgsConstructor
@RequestMapping("/auth")
public class AuthController {

    @GetMapping("/exception")
    public ApiResponse<String> checkException(@RequestParam String flag) throws CryptoServiceException {
        if (StringUtils.isEmpty(flag)) {
            log.info("flag is null");
            throw new CryptoServiceException(ErrorCode.INVALID_INPUT);
        }
        return SuccessResponseBuilder.populate(SuccessCode.FETCH_SUCCESS, flag);
    }


}

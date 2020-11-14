/*
 * Copyright (c) 2020 掘艺网络(jueyi.co).
 * All rights reserved.
 */

package co.jueyi.geekshop;

import lombok.Data;

/**
 * Created on Nov, 2020 by @author bobo
 */
@Data
public class ApiException extends RuntimeException {
    private final String errorCode;
    private final String errorMessage;

    public ApiException(String errorCode, String errorMessage) {
        super(errorMessage);
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }
}

package com.cnu.motion.common.exception;

import com.cnu.motion.common.type.Exception;

public class InvalidRequestException extends RuntimeException {
    private Exception exceptionCode;

    public InvalidRequestException(Exception exceptionCode) {
        this.exceptionCode = exceptionCode;
    }
}

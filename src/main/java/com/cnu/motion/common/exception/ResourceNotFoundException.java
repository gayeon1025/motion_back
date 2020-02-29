package com.cnu.motion.common.exception;

import com.cnu.motion.common.type.Exception;

public class ResourceNotFoundException extends RuntimeException {
    private Exception exceptionCode;

    public ResourceNotFoundException(Exception exceptionCode) {
        this.exceptionCode = exceptionCode;
    }
}

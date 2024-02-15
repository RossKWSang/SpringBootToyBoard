package com.fastcampus.springboottoyboard.common.exception;

import com.fastcampus.springboottoyboard.common.response.ErrorCode;

public class EntityNotFoundException extends BaseException{
    public EntityNotFoundException() {
        super(ErrorCode.COMMON_INVALID_PARAMETER);
    }

    public EntityNotFoundException(String message) {
        super(message, ErrorCode.COMMON_INVALID_PARAMETER);
    }
}

package com.fastcampus.springboottoyboard.common.exception;

import com.fastcampus.springboottoyboard.common.response.ErrorCode;

public class IllegalStatusException extends BaseException{
    public IllegalStatusException() {
        super(ErrorCode.COMMON_ILLEGAL_STATUS);
    }
    public IllegalStatusException(String message) {
        super(message, ErrorCode.COMMON_ILLEGAL_STATUS);
    }
}

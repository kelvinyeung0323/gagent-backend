package com.kelvin.goodsagent.common.exception;

import org.springframework.http.HttpStatus;

/**
 * @author: Kelvin Yeuung
 * @createdAt: 2020/8/9 21:26
 * @description:
 */
public class BizException extends RuntimeException {

    private HttpStatus status =HttpStatus.BAD_REQUEST;

    public BizException() {
    }


    public BizException(HttpStatus status ,String message) {
        super(message);
        this.status = status;
    }
    public BizException(String message) {
        super(message);
    }

    public BizException(String message, Throwable cause) {
        super(message, cause);
    }

    public BizException(Throwable cause) {
        super(cause);
    }

    public BizException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    public HttpStatus getStatus() {
        return status;
    }

    public void setStatus(HttpStatus status) {
        this.status = status;
    }
}

package com.horaoen.smart_safe_campus.core.exception.http;

/**
 * @author horaoen
 */
public class HttpException extends RuntimeException{
    protected Integer code;
    protected Integer httpStatusCode = 500;
    public Integer getCode() {
        return code;
    }

    public Integer getHttpStatusCode() {
        return httpStatusCode;
    }
}

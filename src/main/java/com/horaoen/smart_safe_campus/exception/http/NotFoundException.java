package com.horaoen.smart_safe_campus.exception.http;

/**
 * @author horaoen
 */
public class NotFoundException extends HttpException{
    public NotFoundException(int code) {
        this.httpStatusCode = 404;
        this.code = code;
    }
}

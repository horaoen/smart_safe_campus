package com.horaoen.smart_safe_campus.core.exception.http;

/**
 * @author horaoen
 */
public class ForbiddenException extends HttpException{
    public ForbiddenException(int code) {
        this.code = code;
        this.httpStatusCode = 403;
    }
}

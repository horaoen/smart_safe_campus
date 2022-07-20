package com.horaoen.smart_safe_campus.core;

import com.horaoen.smart_safe_campus.core.configuration.ExceptionCodeConfiguration;
import com.horaoen.smart_safe_campus.exception.http.HttpException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintViolationException;
import java.util.List;

/**
 * @author horaoen
 */
@ControllerAdvice
public class GlobalExceptionAdvice {

    @Autowired
    private ExceptionCodeConfiguration exceptionCodeConfiguration;

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    @ResponseStatus(code = HttpStatus.INTERNAL_SERVER_ERROR)
    public UnifyResponse handleException(HttpServletRequest request, Exception e) {
        String method = request.getMethod();
        String requestUrl = request.getRequestURI();
        System.out.println(e);
        UnifyResponse unifyResponse = new UnifyResponse(9999, "服务器异常", method + " " + requestUrl);
        return unifyResponse;
    }

    @ExceptionHandler(HttpException.class)
    public ResponseEntity<UnifyResponse> handleHttpException(HttpServletRequest request, HttpException e) {
        String method = request.getMethod();
        String requestUrl = request.getRequestURI();
        System.out.println(e);

        UnifyResponse unifyResponse = new UnifyResponse(e.getCode(), exceptionCodeConfiguration.getMessage(e.getCode()),method + " " + requestUrl);
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpStatus httpStatus = HttpStatus.resolve(e.getHttpStatusCode());

        ResponseEntity<UnifyResponse> responseMessage = new ResponseEntity<>(unifyResponse, headers, httpStatus);
        return responseMessage;
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    @ResponseBody
    public UnifyResponse handleBeanValidation(HttpServletRequest request, MethodArgumentNotValidException e) {
        String method = request.getMethod();
        String requestUrl = request.getRequestURI();
        System.out.println(e);

        List<ObjectError> allErrors = e.getBindingResult().getAllErrors();
        String errorMessages = this.formatAllErrorMessages(allErrors);

        return new UnifyResponse(10001, errorMessages, method + " " + requestUrl);
    }

    @ExceptionHandler(ConstraintViolationException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public UnifyResponse handleConstraintException(HttpServletRequest request, ConstraintViolationException e) {
        String method = request.getMethod();
        String requestUrl = request.getRequestURI();
        System.out.println(e);
        String message = e.getMessage();
        return new UnifyResponse(10001, message, message + " " + requestUrl);
    }

    private String formatAllErrorMessages(List<ObjectError> allErrors) {
        StringBuffer errorMsg = new StringBuffer();
        allErrors.forEach(error -> errorMsg.append(error.getDefaultMessage()).append(';'));
        return errorMsg.toString();
    }
}

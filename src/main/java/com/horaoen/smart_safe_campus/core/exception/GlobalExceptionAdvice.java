package com.horaoen.smart_safe_campus.core.exception;

import com.horaoen.smart_safe_campus.common.api.CommonResult;
import com.horaoen.smart_safe_campus.core.UnifyResponse;
import com.horaoen.smart_safe_campus.core.exception.http.HttpException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintViolationException;
import javax.validation.UnexpectedTypeException;
import java.util.List;

/**
 * @author horaoen
 */
@ControllerAdvice
public class GlobalExceptionAdvice {

    @Autowired
    private ExceptionCodeConfig exceptionCodeConfig;

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

        UnifyResponse unifyResponse = new UnifyResponse(e.getCode(), exceptionCodeConfig.getMessage(e.getCode()),method + " " + requestUrl);
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpStatus httpStatus = HttpStatus.resolve(e.getHttpStatusCode());

        ResponseEntity<UnifyResponse> responseMessage = new ResponseEntity<>(unifyResponse, headers, httpStatus);
        return responseMessage;
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    @ResponseBody
    public CommonResult handleBeanValidation(HttpServletRequest request, MethodArgumentNotValidException e) {
        String method = request.getMethod();
        String requestUrl = request.getRequestURI();
        System.out.println(e);

        List<ObjectError> allErrors = e.getBindingResult().getAllErrors();
        String errorMessages = this.formatAllErrorMessages(allErrors);

        return CommonResult.validateFailed(errorMessages);
    }

    @ExceptionHandler(ConstraintViolationException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public CommonResult handleConstraintException(HttpServletRequest request, ConstraintViolationException e) {
        String method = request.getMethod();
        String requestUrl = request.getRequestURI();
        System.out.println(e);
        String message = e.getMessage();
        return CommonResult.validateFailed(message);
    }

    @ExceptionHandler(UnexpectedTypeException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public CommonResult handleUnexpectedTypeException(HttpServletRequest request, UnexpectedTypeException e) {
        String method = request.getMethod();
        String requestUrl = request.getRequestURI();
        System.out.println(e);
        String message = e.getMessage();
        return CommonResult.validateFailed(message);
    }

    private String formatAllErrorMessages(List<ObjectError> allErrors) {
        StringBuffer errorMsg = new StringBuffer();
        allErrors.forEach(error -> errorMsg.append(error.getDefaultMessage()).append(';'));
        return errorMsg.toString();
    }


}

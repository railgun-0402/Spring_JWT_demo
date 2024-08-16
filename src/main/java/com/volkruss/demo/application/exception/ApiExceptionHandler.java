package com.volkruss.demo.application.exception;

import com.volkruss.demo.application.exception.coin.NotEnoughException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice(annotations = RestController.class)
public class ApiExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler(NotEnoughException.class)
    public Map<String, Object> handleNotEnoughException(
            Exception exception, WebRequest webRequest) {
        Map<String, Object> errors = new HashMap<>();
        errors.put("message", "コインが足りません");
        return errors;
    }
}

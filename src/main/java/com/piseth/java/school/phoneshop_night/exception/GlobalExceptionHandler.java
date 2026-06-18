package com.piseth.java.school.phoneshop_night.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(ApiException.class)
    public ResponseEntity<?> handleApiException(ApiException e) {
        ErrorReponse errorReponse = new ErrorReponse(e.getStatus(), e.getMessage());
        return ResponseEntity.status(e.getStatus()).body(errorReponse);

    }
}

package com.zonner.RandomActivityApp.exceptions.Activity;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ActivityExceptionHandler {
    @ExceptionHandler(value = ActivityException.class)
    public ResponseEntity<ActivityErrorInfo> handlerActivityException(ActivityException exception) {
        HttpStatus httpStatus = HttpStatus.MULTI_STATUS;
        if (ActivityError.ACTIVITY_NOT_FOUND.equals(exception.getActivityError())) {
            httpStatus = HttpStatus.NOT_FOUND;
        }
        if (ActivityError.ACTIVITY_ALREADY_EXISTS.equals(exception.getActivityError())) {
            httpStatus = HttpStatus.BAD_REQUEST;
        }
        return ResponseEntity.status(httpStatus).body(new ActivityErrorInfo(exception.getActivityError().getMessage()));
    }
}

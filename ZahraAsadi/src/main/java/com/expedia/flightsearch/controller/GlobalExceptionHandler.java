package com.expedia.flightsearch.controller;

import com.expedia.flightsearch.factory.ErrorResponseFactory;
import com.expedia.flightsearch.model.error.ApiError;
import org.springframework.boot.json.JsonParseException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.io.IOException;
import java.time.format.DateTimeParseException;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    private ResponseEntity<ApiError> buildBadRequestErrorEntity(ApiError apiError) {
        return ResponseEntity.badRequest().body(apiError);
    }

    @ExceptionHandler(value = DateTimeParseException.class)
    public ResponseEntity<ApiError> exceptionHandler(DateTimeParseException e) {
        ApiError apiError = ErrorResponseFactory.buildBadRequestErrorResponse(e.getMessage());
        return buildBadRequestErrorEntity(apiError);
    }

    @ExceptionHandler(value = JsonParseException.class)
    public ResponseEntity<ApiError> exceptionHandler(JsonParseException e){
        ApiError apiError = ErrorResponseFactory.buildBadRequestErrorResponse(e.getMessage());
        return null;
    }


}

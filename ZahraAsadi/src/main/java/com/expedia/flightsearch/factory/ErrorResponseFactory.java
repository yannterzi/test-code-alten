package com.expedia.flightsearch.factory;

import com.expedia.flightsearch.model.error.ApiError;

public class ErrorResponseFactory {

    private ErrorResponseFactory(){

    }

    public static ApiError buildBadRequestErrorResponse(String message){

        return ApiError.builder().message("Please enter the time in a given format, i.e 7:30AM").status(400).build();
    }
}

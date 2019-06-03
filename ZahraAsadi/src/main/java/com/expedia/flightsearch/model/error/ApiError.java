package com.expedia.flightsearch.model.error;

import com.expedia.flightsearch.factory.ErrorResponseFactory;
import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
public class ApiError {

    private Integer status;
    private String message;


    private ApiError(ApiErrorResponseBuilder apiErrorResponseBuilder) {
        this.message = apiErrorResponseBuilder.message;
        this.status = apiErrorResponseBuilder.status;
    }

    public static ApiErrorResponseBuilder builder(){
        return new ApiErrorResponseBuilder();
    }

    public static class ApiErrorResponseBuilder {

        private Integer status;
        private String message;

        public ApiErrorResponseBuilder status(Integer status) {
            this.status = status;
            return this;
        }

        public ApiErrorResponseBuilder status(HttpStatus httpStatus) {
            this.status = httpStatus.value();
            return this;
        }

        public ApiErrorResponseBuilder message(String message) {
            this.message = message;
            return this;
        }

        public ApiError build() {
            return new ApiError(this);
        }
    }
}

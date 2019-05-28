package com.expedia.flightsearch.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.expedia.flightsearch.util.ErrorMessage;

/**
 * The Class BadRequestExceptionHandler.
 */
@ControllerAdvice
public class BadRequestExceptionHandler {

	
	    /**
    	 * Handle bad request.
    	 *
    	 * @param e the e
    	 * @return the response entity
    	 */
    	@ExceptionHandler(BadRequestException.class)
	    @ResponseStatus(value=HttpStatus.BAD_REQUEST)
	    @ResponseBody
	    public ResponseEntity<ErrorMessage> handleBadRequest(BadRequestException e) {
           ErrorMessage errorMessage = new ErrorMessage("\"error : "+ e.getMessage() , 400); 
	        return new ResponseEntity<ErrorMessage>(errorMessage, HttpStatus.BAD_REQUEST);
	    }
	
}

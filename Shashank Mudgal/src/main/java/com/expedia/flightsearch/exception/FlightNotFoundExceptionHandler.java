package com.expedia.flightsearch.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.expedia.flightsearch.util.ErrorMessage;

/**
 * The Class FlightNotFoundExceptionHandler.
 */
@ControllerAdvice
public class FlightNotFoundExceptionHandler {

	    /**
    	 * Handle flight not found.
    	 *
    	 * @param e the e
    	 * @return the response entity
    	 */
    	@ExceptionHandler(FlightNotFoundException.class)
	    @ResponseStatus(value=HttpStatus.NOT_FOUND)
	    @ResponseBody
	    public ResponseEntity<ErrorMessage> handleFlightNotFound(FlightNotFoundException e) {
            ErrorMessage errorMessage = new ErrorMessage("\"error : "+ e.getMessage() , 404); 
	        return new ResponseEntity<ErrorMessage>(errorMessage, HttpStatus.NOT_FOUND);
	    }
	    
}

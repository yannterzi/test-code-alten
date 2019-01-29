package com.expedia.rest.flightsearch.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.expedia.rest.flightsearch.vo.ExceptionResponse;

/**
 * The GlobalExceptionHandler is the Controller Advice and subclass of the ResponseEntityExceptionHandler.
 * It handles the global exception which raised from the Rest Controller and return the proper response to the client.
 *
 * @author Arun Patel
 * @version 1.0
 * @since 2019-01-22
 */

@ControllerAdvice
@RestController
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

	/**
	 * handleAllException handles all the exceptions of type Exception.
	 * 
	 * @param Exception It represents the raised exception.
	 * @param WebRequest It represents the request.
	 * @return ResponseEntity It represents the response of the exception with proper http status code. 
	 */

	@ExceptionHandler(Exception.class)
	public final ResponseEntity<Object> handleAllException(Exception ex, WebRequest request) {

		ExceptionResponse response = new ExceptionResponse(String.valueOf(HttpStatus.INTERNAL_SERVER_ERROR.value()),
				ex.getMessage(), request.getDescription(false));
		return new ResponseEntity<Object>(response, HttpStatus.INTERNAL_SERVER_ERROR);
	}


	/**
	 * handleInvalidSearchException handles all the exceptions of type InvalidSearchCriteriaException.
	 * 
	 * @param InvalidSearchCriteriaException It represents the custom exception raised by the code.
	 * @return ResponseEntity It represents the response of the exception with proper http status code. 
	 */
	@ExceptionHandler(InvalidSearchCriteriaException.class)
	public final ResponseEntity<Object> handleInvalidSearchException(
			InvalidSearchCriteriaException invalidSearchCriteriaEx) {

		ExceptionResponse response = new ExceptionResponse(String.valueOf(HttpStatus.BAD_REQUEST.value()),
				invalidSearchCriteriaEx.getErrorCode(), invalidSearchCriteriaEx.getMessage());
		return new ResponseEntity<Object>(response, HttpStatus.BAD_REQUEST);
	}
}
package com.expedia.rest.flightsearch.exception;

import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;

/**
 * The InvalidSearchCriteriaException is custom exception. Application will
 * throw this exception when input search parameter is not in proper format.
 * 
 * @author Arun Patel
 * @version 1.0
 * @since 2019-01-22
 */
@ResponseStatus(HttpStatus.BAD_REQUEST)
public class InvalidSearchCriteriaException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	private String errorCode;
	private String message;

	public InvalidSearchCriteriaException(String errorCode, String message) {
		this.errorCode = errorCode;
		this.message = message;
	}

	public String getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}

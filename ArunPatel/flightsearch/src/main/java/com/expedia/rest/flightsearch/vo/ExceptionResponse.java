package com.expedia.rest.flightsearch.vo;

/**
 * The ExceptionResponse is used to return the proper response format.
 *
 * @author Arun Patel
 * @version 1.0
 * @since 2019-01-22
 */

public class ExceptionResponse {

	private String statusCode;
	private String errorCode = "";
	private String message;

	public ExceptionResponse(String statusCode, String errorCode, String message) {
		this.statusCode = statusCode;
		this.errorCode = errorCode;
		this.message = message;
	}

	public String getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(String statusCode) {
		this.statusCode = statusCode;
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

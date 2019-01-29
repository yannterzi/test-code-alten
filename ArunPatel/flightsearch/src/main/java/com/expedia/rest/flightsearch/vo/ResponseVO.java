package com.expedia.rest.flightsearch.vo;

/**
 * The ResponseVO is generic class which is used to return the proper response
 * format.
 *
 * @author Arun Patel
 * @version 1.0
 * @since 2019-01-22
 */

public class ResponseVO<T> {

	private String statusCode;
	private String errorCode = "";
	private String message;
	private T data;

	public String getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(Integer statusCode) {
		this.statusCode = String.valueOf(statusCode);
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

	public T getData() {
		if (data == null) {
			this.setData(null);
		}
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}
}

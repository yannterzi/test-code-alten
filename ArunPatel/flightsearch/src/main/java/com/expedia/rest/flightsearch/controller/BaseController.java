package com.expedia.rest.flightsearch.controller;

import org.springframework.http.HttpStatus;

import com.expedia.rest.flightsearch.vo.ResponseVO;

/**
 * The Base Controller is Parent Controller of all the Rest Controller. It
 * provides the common implementation which required to all Rest Controller.
 *
 * @author Arun Patel
 * @version 1.0
 * @since 2019-01-22
 */

public class BaseController {

	protected <T> ResponseVO<T> prepareSuccessResponse(T data) {
		ResponseVO<T> response = new ResponseVO<>();
		response.setData(data);
		response.setStatusCode(HttpStatus.OK.value());
		response.setMessage(HttpStatus.OK.name());
		return response;
	}

	protected <T> ResponseVO<T> prepareResponse(T data, int statusCode, String message) {
		ResponseVO<T> response = new ResponseVO<>();
		response.setData(data);
		response.setStatusCode(statusCode);
		response.setMessage(message);
		return response;
	}
}
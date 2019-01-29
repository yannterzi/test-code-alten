package com.expedia.example.demo;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.expedia.example.demo.model.ErrorDTO;


@Controller
@RestController
public class CustomErrorController implements ErrorController {

	private static final Logger logger = LoggerFactory.getLogger(CustomErrorController.class);

	@GetMapping("/error")
	public ErrorDTO handle(Map<String, Object> model, HttpServletRequest request) {

		Integer statusCode = (Integer) request.getAttribute("javax.servlet.error.status_code");
		Exception exception = (Exception) request.getAttribute("javax.servlet.error.exception");
		String path = (String) request.getAttribute("javax.servlet.error.request_uri");

		logger.error("Error happen, detail is", exception);
		
	    ErrorDTO error = new ErrorDTO();
	    error.setErrorCode(statusCode);
        error.setErrorUrl(path);
        error.setErrorMsg(exception == null || exception.getMessage() == null ? "" : exception.getMessage());
	    
		return error;
	}

	@Override
	public String getErrorPath() {
		return "/error";
	}

}

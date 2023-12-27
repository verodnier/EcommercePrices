package com.ecommerce.prices.application.errors;

import org.springframework.http.HttpStatus;

import lombok.Data;

@Data
public class ErrorResponse {
	
	private HttpStatus httpStatus;
	
	private String errorCode;
	
	private String message;
	
	public ErrorResponse(String errorCode) {
		ErrorInfo errorInfo = ErrorCodeInfoMapper.getMessageByErrorCode(errorCode);
		this.errorCode = errorCode;
		this.httpStatus = errorInfo.getHttpStatus();
		this.message = errorInfo.getMessage();
	}

}

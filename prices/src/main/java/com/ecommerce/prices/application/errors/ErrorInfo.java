package com.ecommerce.prices.application.errors;

import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ErrorInfo {
	
	private HttpStatus httpStatus;
	
	private String message;

}

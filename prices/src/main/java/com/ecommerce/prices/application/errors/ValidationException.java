package com.ecommerce.prices.application.errors;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class ValidationException extends Exception {
	
	private static final long serialVersionUID = 1L;
	
	private String errorCode;
	
	public ValidationException(String errorCode) {
		super();
		this.errorCode = errorCode;
	}
	
}

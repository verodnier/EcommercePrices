package com.ecommerce.prices.application.errors;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;

public class ErrorCodeInfoMapper {
	
	private static final Map<String, ErrorInfo> errorCodeMessageHashMap;
	
	static {
		errorCodeMessageHashMap = new HashMap<>();
		errorCodeMessageHashMap.put(ErrorCode.ERROR_INCORRECT_PARAMETER, 
				new ErrorInfo(HttpStatus.BAD_REQUEST, "Parámetro(s) incorrecto(s)"));
		errorCodeMessageHashMap.put(ErrorCode.ERROR_PRICE_NOT_FOUND, 
				new ErrorInfo(HttpStatus.NOT_FOUND, "Precio no encontrado"));
	}
	
	public static ErrorInfo getMessageByErrorCode(String errorCode) {
		return errorCodeMessageHashMap.getOrDefault(errorCode, null);
	}

}

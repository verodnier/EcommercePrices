package com.ecommerce.prices.input.web;

import java.sql.Timestamp;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.prices.application.data.dto.PriceResponseDTO;
import com.ecommerce.prices.application.errors.ErrorResponse;
import com.ecommerce.prices.application.errors.ValidationException;
import com.ecommerce.prices.application.usecases.PricesUseCases;

@RequestMapping("/prices")
@RestController
public class PricesApi {
	
	private final Logger log = LoggerFactory.getLogger(PricesApi.class);
	
	@Autowired
	private PricesUseCases pricesUseCases;
	
	@GetMapping("/")
	public ResponseEntity<?> findPriceByBrandIdProductIdAndApplicationDate(
			@RequestParam("brandId") Long brandId, 
			@RequestParam("productId") Long productId, 
			@RequestParam("applicationDate") Timestamp applicationDate
			) {
		
		log.info("REST request to find price by brandId, productId and applicationDate");
		
		try {
			PriceResponseDTO priceResponseDTO = this.pricesUseCases
					.findPriceByBrandIdProductIdAndApplicationDate(brandId, productId, applicationDate);
			
			return ResponseEntity.status(HttpStatus.OK).body(priceResponseDTO);
			
		} catch (ValidationException e) {
			log.error("ValidationException: ", e);
			
			ErrorResponse errorResponse = new ErrorResponse(e.getErrorCode());
			
			return ResponseEntity.status(errorResponse.getHttpStatus()).body(errorResponse);
		}
	}
}

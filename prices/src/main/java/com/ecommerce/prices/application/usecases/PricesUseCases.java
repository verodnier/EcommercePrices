package com.ecommerce.prices.application.usecases;

import java.sql.Timestamp;

import com.ecommerce.prices.application.data.dto.PriceResponseDTO;
import com.ecommerce.prices.application.errors.ValidationException;

public interface PricesUseCases {
	
	PriceResponseDTO findPriceByBrandIdProductIdAndApplicationDate(
			Long brandId, 
			Long productId,
			Timestamp applicationDate) throws ValidationException;

}

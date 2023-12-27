package com.ecommerce.prices.output.repository;

import java.sql.Timestamp;

import com.ecommerce.prices.domain.entities.Price;

public interface PriceRepository {
	
	Price findPriceByBrandIdProductIdAndApplicationDate(
			Long brandId, 
			Long productId, 
			Timestamp applicationDate);

}

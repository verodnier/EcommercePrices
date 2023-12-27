package com.ecommerce.prices.domain.services;

import java.sql.Timestamp;

import com.ecommerce.prices.domain.entities.Price;

public interface PriceService {
	
	Price findPriceByBrandIdProductIdAndApplicationDate(
			Long brandId, Long productId, Timestamp applicationDate);

}

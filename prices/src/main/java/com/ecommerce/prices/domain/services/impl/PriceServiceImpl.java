package com.ecommerce.prices.domain.services.impl;

import java.sql.Timestamp;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.prices.domain.entities.Price;
import com.ecommerce.prices.domain.services.PriceService;
import com.ecommerce.prices.output.repository.PriceRepository;

@Service
public class PriceServiceImpl implements PriceService {
	
	private final Logger log = LoggerFactory.getLogger(PriceServiceImpl.class);
	
	@Autowired
	private PriceRepository priceRepository;

	@Override
	public Price findPriceByBrandIdProductIdAndApplicationDate(
			Long brandId, 
			Long productId,
			Timestamp applicationDate
			) {
		
		log.debug("Request to find price by brandId: {}, productId: {} and applicationDate: {} in PriceService"
				, brandId, productId, applicationDate);
		
		return this.priceRepository.findPriceByBrandIdProductIdAndApplicationDate(
				brandId, productId, applicationDate);
	}

}

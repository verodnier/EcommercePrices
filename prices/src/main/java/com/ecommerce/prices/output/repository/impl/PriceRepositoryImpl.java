package com.ecommerce.prices.output.repository.impl;

import java.sql.Timestamp;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Repository;

import com.ecommerce.prices.domain.entities.Price;
import com.ecommerce.prices.infrastructure.repository.PriceJpaRepository;
import com.ecommerce.prices.output.repository.PriceRepository;

@Repository
public class PriceRepositoryImpl implements PriceRepository {
	
	private final Logger log = LoggerFactory.getLogger(PriceRepositoryImpl.class);
	
	@Autowired
	private PriceJpaRepository priceJpaRepository;

	@Override
	public Price findPriceByBrandIdProductIdAndApplicationDate(Long brandId, Long productId,
			Timestamp applicationDate) {
		
		log.debug("Request to find price by brandId: {}, productId: {} and applicationDate: {} in PriceRepository"
				, brandId, productId, applicationDate);
		
		List<Price> priceList = this.priceJpaRepository.findPriceByBrandIdProductIdAndApplicationDate(
				brandId, productId, applicationDate, PageRequest.of(0, 1));
		
		return priceList == null || priceList.isEmpty() ? null : priceList.get(0);
	}

}

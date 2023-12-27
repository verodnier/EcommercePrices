package com.ecommerce.prices.application.usecases.impl;

import java.sql.Timestamp;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.prices.application.data.dto.PriceResponseDTO;
import com.ecommerce.prices.application.data.mappers.PriceMapper;
import com.ecommerce.prices.application.errors.ErrorCode;
import com.ecommerce.prices.application.errors.ValidationException;
import com.ecommerce.prices.application.usecases.PricesUseCases;
import com.ecommerce.prices.domain.entities.Price;
import com.ecommerce.prices.domain.services.PriceService;

@Service
public class PricesUseCasesImpl implements PricesUseCases {
	
	private final Logger log = LoggerFactory.getLogger(PricesUseCasesImpl.class);

	@Autowired
	private PriceService priceService;
	
	@Autowired
	private PriceMapper priceMapper;

	@Override
	public PriceResponseDTO findPriceByBrandIdProductIdAndApplicationDate(Long brandId, Long productId,
			Timestamp applicationDate) throws ValidationException {
		
		log.info("Request to find price by brandId: {}, productId: {} and applicationDate: {} in PricesUseCases"
				, brandId, productId, applicationDate);
		
		if (brandId == null || productId == null || applicationDate == null) {
			throw new ValidationException(ErrorCode.ERROR_INCORRECT_PARAMETER);
		}
		
		Price price = this.priceService.findPriceByBrandIdProductIdAndApplicationDate(
				brandId, productId, applicationDate);
		
		if (price == null) {
			throw new ValidationException(ErrorCode.ERROR_PRICE_NOT_FOUND);
		}
		
		return this.priceMapper.toDto(price);
	}

}

package com.ecommerce.prices.application.data.dto;

import java.io.Serializable;
import java.sql.Timestamp;

import lombok.Data;

@Data
public class PriceResponseDTO implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private Long brandId;
	
	private Long productId;
	
	private Long priceList;
	
	private Timestamp startDate;
	
	private Timestamp endDate;
	
	private Double price;

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof PriceResponseDTO))
			return false;
		PriceResponseDTO other = (PriceResponseDTO) obj;
		if (brandId == null) {
			if (other.brandId != null)
				return false;
		} else if (!brandId.equals(other.brandId))
			return false;
		if (endDate == null) {
			if (other.endDate != null)
				return false;
		} else if (!endDate.equals(other.endDate))
			return false;
		if (price == null) {
			if (other.price != null)
				return false;
		} else if (!price.equals(other.price))
			return false;
		if (priceList == null) {
			if (other.priceList != null)
				return false;
		} else if (!priceList.equals(other.priceList))
			return false;
		if (productId == null) {
			if (other.productId != null)
				return false;
		} else if (!productId.equals(other.productId))
			return false;
		if (startDate == null) {
			if (other.startDate != null)
				return false;
		} else if (!startDate.equals(other.startDate))
			return false;
		return true;
	}

}

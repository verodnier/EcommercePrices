package com.ecommerce.prices.domain.entities;

import java.sql.Timestamp;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "price")
@Data
public class Price {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
	@SequenceGenerator(name = "sequenceGenerator")
	private Long id;
	
	@Column(name = "brand_id")
	private Long brandId;
	
	@Column(name = "product_id")
	private Long productId;
	
	@Column(name = "price_list")
	private Long priceList;
	
	@Column(name = "priority")
	private Integer priority;
	
	@Column(name = "start_date")
	private Timestamp startDate;
	
	@Column(name = "end_date")
	private Timestamp endDate;
	
	@Column(name = "price")
	private Double price;
	
	@Column(name = "curr")
	private String curr;
	
}

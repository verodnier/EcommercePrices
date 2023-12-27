package com.ecommerce.prices.infrastructure.repository;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ecommerce.prices.domain.entities.Price;

@Repository
public interface PriceJpaRepository extends JpaRepository<Price, Long> {
	
	@Query(	" FROM Price p " + 
			" WHERE p.brandId = :brandId " +
				" AND p.productId = :productId " +
				" AND p.startDate <= :applicationDate " +
				" AND p.endDate >= :applicationDate " +
			" ORDER BY p.priority DESC ")
	List<Price> findPriceByBrandIdProductIdAndApplicationDate(
			Long brandId, 
			Long productId, 
			Timestamp applicationDate,
			Pageable pageable);
}

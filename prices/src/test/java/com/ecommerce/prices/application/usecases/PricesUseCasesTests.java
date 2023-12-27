package com.ecommerce.prices.application.usecases;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.sql.Timestamp;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;

import com.ecommerce.prices.application.data.dto.PriceResponseDTO;
import com.ecommerce.prices.application.data.mappers.PriceMapper;
import com.ecommerce.prices.application.errors.ValidationException;
import com.ecommerce.prices.application.usecases.impl.PricesUseCasesImpl;
import com.ecommerce.prices.domain.entities.Price;
import com.ecommerce.prices.domain.services.PriceService;

@SpringBootTest
@ActiveProfiles("test")
public class PricesUseCasesTests {
	
	@Autowired
	PricesUseCasesImpl pricesUseCases;
	
	@MockBean
	PriceService priceService;
	
	@MockBean
	PriceMapper priceMapper;
	
	@Test
	@DisplayName("findPriceByBrandIdProductIdAndApplicationDateTest")
	void findPriceByBrandIdProductIdAndApplicationDateTest() {
		
		// TEST DATA
		Price price1 = new Price();
		price1.setBrandId(1L);
		price1.setProductId(35455L);
		price1.setPriceList(1L);
		price1.setPriority(0);
		price1.setStartDate(Timestamp.valueOf("2020-06-14 00:00:00"));
		price1.setEndDate(Timestamp.valueOf("2020-12-31 23:59:59"));
		price1.setPrice(35.50);
		price1.setCurr("EUR");
		
		Price price2 = new Price();
		price2.setBrandId(1L);
		price2.setProductId(35455L);
		price2.setPriceList(2L);
		price2.setPriority(1);
		price2.setStartDate(Timestamp.valueOf("2020-06-14 15:00:00"));
		price2.setEndDate(Timestamp.valueOf("2020-06-14 18:30:00"));
		price2.setPrice(25.45);
		price2.setCurr("EUR");
		
		Price price3 = new Price();
		price3.setBrandId(1L);
		price3.setProductId(35455L);
		price3.setPriceList(3L);
		price3.setPriority(1);
		price3.setStartDate(Timestamp.valueOf("2020-06-15 00:00:00"));
		price3.setEndDate(Timestamp.valueOf("2020-06-15 11:00:00"));
		price3.setPrice(30.50);
		price3.setCurr("EUR");
		
		Price price4 = new Price();
		price4.setBrandId(1L);
		price4.setProductId(35455L);
		price4.setPriceList(4L);
		price4.setPriority(1);
		price4.setStartDate(Timestamp.valueOf("2020-06-15 16:00:00"));
		price4.setEndDate(Timestamp.valueOf("2020-12-31 23:59:59"));
		price4.setPrice(38.95);
		price4.setCurr("EUR");
		
		PriceResponseDTO priceResponseDTO1 = new PriceResponseDTO();
		priceResponseDTO1.setBrandId(1L);
		priceResponseDTO1.setProductId(35455L);
		priceResponseDTO1.setPriceList(1L);
		priceResponseDTO1.setStartDate(Timestamp.valueOf("2020-06-14 00:00:00"));
		priceResponseDTO1.setEndDate(Timestamp.valueOf("2020-12-31 23:59:59"));
		priceResponseDTO1.setPrice(35.50);
		
		PriceResponseDTO priceResponseDTO2 = new PriceResponseDTO();
		priceResponseDTO2.setBrandId(1L);
		priceResponseDTO2.setProductId(35455L);
		priceResponseDTO2.setPriceList(2L);
		priceResponseDTO2.setStartDate(Timestamp.valueOf("2020-06-14 15:00:00"));
		priceResponseDTO2.setEndDate(Timestamp.valueOf("2020-06-14 18:30:00"));
		priceResponseDTO2.setPrice(25.45);
		
		PriceResponseDTO priceResponseDTO3 = new PriceResponseDTO();
		priceResponseDTO3.setBrandId(1L);
		priceResponseDTO3.setProductId(35455L);
		priceResponseDTO3.setPriceList(3L);
		priceResponseDTO3.setStartDate(Timestamp.valueOf("2020-06-15 00:00:00"));
		priceResponseDTO3.setEndDate(Timestamp.valueOf("2020-06-15 11:00:00"));
		priceResponseDTO3.setPrice(30.50);
		
		PriceResponseDTO priceResponseDTO4 = new PriceResponseDTO();
		priceResponseDTO4.setBrandId(1L);
		priceResponseDTO4.setProductId(35455L);
		priceResponseDTO4.setPriceList(4L);
		priceResponseDTO4.setStartDate(Timestamp.valueOf("2020-06-15 16:00:00"));
		priceResponseDTO4.setEndDate(Timestamp.valueOf("2020-12-31 23:59:59"));
		priceResponseDTO4.setPrice(38.95);
		
		// TESTS
		assertAll(
				() -> {
				
					when(priceService.findPriceByBrandIdProductIdAndApplicationDate(1L, 35455L,Timestamp.valueOf("2020-06-14 10:00:00")))
			        .thenReturn(price1);
					
					when(priceMapper.toDto(price1)).thenReturn(priceResponseDTO1);
					
					assertEquals(
							priceResponseDTO1, 
							pricesUseCases.findPriceByBrandIdProductIdAndApplicationDate(1L, 35455L, Timestamp.valueOf("2020-06-14 10:00:00")), 
							() -> "CASO_PRUEBA_1");
					
					verify(priceService, times(1)).findPriceByBrandIdProductIdAndApplicationDate(1L, 35455L,Timestamp.valueOf("2020-06-14 10:00:00"));
					verify(priceMapper, times(1)).toDto(price1);
				
				}, () -> {
				
					when(priceService.findPriceByBrandIdProductIdAndApplicationDate(1L, 35455L,Timestamp.valueOf("2020-06-14 16:00:00")))
			        .thenReturn(price2);
					
					when(priceMapper.toDto(price2)).thenReturn(priceResponseDTO2);
					
					assertEquals(
							priceResponseDTO2, 
							pricesUseCases.findPriceByBrandIdProductIdAndApplicationDate(1L, 35455L, Timestamp.valueOf("2020-06-14 16:00:00")), 
							() -> "CASO_PRUEBA_2");
				
				}, () -> {

					when(priceService.findPriceByBrandIdProductIdAndApplicationDate(1L, 35455L,Timestamp.valueOf("2020-06-14 21:00:00")))
			        .thenReturn(price1);
					
					when(priceMapper.toDto(price1)).thenReturn(priceResponseDTO1);
					
					assertEquals(
							priceResponseDTO1, 
							pricesUseCases.findPriceByBrandIdProductIdAndApplicationDate(1L, 35455L, Timestamp.valueOf("2020-06-14 21:00:00")), 
							() -> "CASO_PRUEBA_3");
				
				}, () -> {
					
					when(priceService.findPriceByBrandIdProductIdAndApplicationDate(1L, 35455L,Timestamp.valueOf("2020-06-15 10:00:00")))
			        .thenReturn(price3);
					
					when(priceMapper.toDto(price3)).thenReturn(priceResponseDTO3);
					
					assertEquals(
							priceResponseDTO3, 
							pricesUseCases.findPriceByBrandIdProductIdAndApplicationDate(1L, 35455L, Timestamp.valueOf("2020-06-15 10:00:00")), 
							() -> "CASO_PRUEBA_4");
					
				}, () -> {
	
					when(priceService.findPriceByBrandIdProductIdAndApplicationDate(1L, 35455L,Timestamp.valueOf("2020-06-16 21:00:00")))
			        .thenReturn(price4);
					
					when(priceMapper.toDto(price4)).thenReturn(priceResponseDTO4);
					
					assertEquals(
							priceResponseDTO4, 
							pricesUseCases.findPriceByBrandIdProductIdAndApplicationDate(1L, 35455L, Timestamp.valueOf("2020-06-16 21:00:00")), 
							() -> "CASO_PRUEBA_5");
					
				}, () -> {
	
					when(priceService.findPriceByBrandIdProductIdAndApplicationDate(1L, 35455L,Timestamp.valueOf("2020-06-14 00:00:00")))
			        .thenReturn(price1);
					
					when(priceMapper.toDto(price1)).thenReturn(priceResponseDTO1);
					
					assertEquals(
							priceResponseDTO1, 
							pricesUseCases.findPriceByBrandIdProductIdAndApplicationDate(1L, 35455L, Timestamp.valueOf("2020-06-14 00:00:00")), 
							() -> "CASO_PRUEBA_6");
					
				}, () -> {
					
					when(priceService.findPriceByBrandIdProductIdAndApplicationDate(1L, 35455L,Timestamp.valueOf("2020-06-13 01:00:00")))
			        .thenReturn(null);
					
					assertThrows(
							ValidationException.class, 
							() -> pricesUseCases.findPriceByBrandIdProductIdAndApplicationDate(1L, 35455L, Timestamp.valueOf("2020-06-13 01:00:00")), 
							() -> "CASO_PRUEBA_7");
					
				}, () -> {
	
					when(priceService.findPriceByBrandIdProductIdAndApplicationDate(1L, 35455L,Timestamp.valueOf("2020-12-31 23:59:59")))
			        .thenReturn(price4);
					
					when(priceMapper.toDto(price4)).thenReturn(priceResponseDTO4);
					
					assertEquals(
							priceResponseDTO4, 
							pricesUseCases.findPriceByBrandIdProductIdAndApplicationDate(1L, 35455L, Timestamp.valueOf("2020-12-31 23:59:59")), 
							() -> "CASO_PRUEBA_8");
					
				}, () -> {
					
					when(priceService.findPriceByBrandIdProductIdAndApplicationDate(1L, 35455L,Timestamp.valueOf("2021-01-01 00:00:00")))
			        .thenReturn(null);
					
					assertThrows(
							ValidationException.class, 
							() -> pricesUseCases.findPriceByBrandIdProductIdAndApplicationDate(1L, 35455L, Timestamp.valueOf("2021-01-01 00:00:00")), 
							() -> "CASO_PRUEBA_9");
					
				}, () -> {
					
					when(priceService.findPriceByBrandIdProductIdAndApplicationDate(2L, 35455L,Timestamp.valueOf("2020-06-14 00:00:00")))
			        .thenReturn(null);
					
					assertThrows(
							ValidationException.class, 
							() -> pricesUseCases.findPriceByBrandIdProductIdAndApplicationDate(2L, 35455L, Timestamp.valueOf("2020-06-14 00:00:00")), 
							() -> "CASO_PRUEBA_10");
					
				}, () -> {
					
					when(priceService.findPriceByBrandIdProductIdAndApplicationDate(1L, 45546L,Timestamp.valueOf("2020-06-14 00:00:00")))
			        .thenReturn(null);
					
					assertThrows(
							ValidationException.class, 
							() -> pricesUseCases.findPriceByBrandIdProductIdAndApplicationDate(1L, 45546L, Timestamp.valueOf("2020-06-14 00:00:00")), 
							() -> "CASO_PRUEBA_11");
					
				},
				
				() -> assertThrows(
						ValidationException.class, 
						() -> pricesUseCases.findPriceByBrandIdProductIdAndApplicationDate(null, null, null), 
						() -> "CASO_PRUEBA_12"),
				
				() -> assertThrows(
						ValidationException.class, 
						() -> pricesUseCases.findPriceByBrandIdProductIdAndApplicationDate(null, 35455L, Timestamp.valueOf("2020-06-14 00:00:00")), 
						() -> "CASO_PRUEBA_13"),
				
				() -> assertThrows(
						ValidationException.class, 
						() -> pricesUseCases.findPriceByBrandIdProductIdAndApplicationDate(null, 35455L, null), 
						() -> "CASO_PRUEBA_14")
		);
	}

}

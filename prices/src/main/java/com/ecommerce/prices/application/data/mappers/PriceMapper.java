package com.ecommerce.prices.application.data.mappers;

import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

import com.ecommerce.prices.application.data.dto.PriceResponseDTO;
import com.ecommerce.prices.domain.entities.Price;

@Component
@Mapper(componentModel = "spring")
public interface PriceMapper extends EntityMapper<PriceResponseDTO, Price> {

}

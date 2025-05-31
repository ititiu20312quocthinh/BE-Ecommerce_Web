package org.sang.backendecommerce.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import org.sang.backendecommerce.dto.model.CartDTO;
import org.sang.backendecommerce.model.Cart;

@Mapper
public interface CartMapper {
	CartMapper INSTANCE = Mappers.getMapper(CartMapper.class);
	@Mapping(target = "cartProducts", ignore = true)
	CartDTO toCartDTO(Cart cart);
	Cart toCart(CartDTO cartDTO);
}

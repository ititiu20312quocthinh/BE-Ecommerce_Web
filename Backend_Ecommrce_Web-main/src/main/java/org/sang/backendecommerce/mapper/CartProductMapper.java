package org.sang.backendecommerce.mapper;

import java.util.List;
import java.util.Set;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import org.sang.backendecommerce.dto.model.CartProductDTO;
import org.sang.backendecommerce.model.CartProduct;

@Mapper
public interface CartProductMapper {
	CartProductMapper INSTANCE = Mappers.getMapper(CartProductMapper.class);
	@Mapping(target = "cart", ignore = true)
	CartProductDTO toCartProductDTO(CartProduct cartProduct);
	CartProduct toCartProduct(CartProductDTO cartProductDTO);
	Set<CartProductDTO> toCartProductDTOList(Set<CartProduct> cartProducts);
	Set<CartProductDTO> toCartProductDTOs(List<CartProduct> cartProducts);
}

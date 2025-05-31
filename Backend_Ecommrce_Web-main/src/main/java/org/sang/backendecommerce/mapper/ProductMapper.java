package org.sang.backendecommerce.mapper;

import java.util.List;
import java.util.Set;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.sang.backendecommerce.dto.model.ProductDTO;
import org.sang.backendecommerce.model.Product;

@Mapper
public interface ProductMapper {
	ProductMapper INSTANCE = Mappers.getMapper(ProductMapper.class);
	ProductDTO toProductDTO(Product product);
	Product toProduct(ProductDTO productDTO);
	List<ProductDTO> toProductDTOList(List<Product> products);
	Set<ProductDTO> toProductDTOSet(Set<Product> products);
}

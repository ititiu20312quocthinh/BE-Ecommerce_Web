package org.sang.backendecommerce.mapper;

import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import org.sang.backendecommerce.dto.model.OrderProductDTO;
import org.sang.backendecommerce.model.OrderProduct;

@Mapper
public interface OrderProductMapper {
	OrderProductMapper INSTANCE = Mappers.getMapper(OrderProductMapper.class);
	@Mapping(target = "order", ignore = true)
	OrderProductDTO toOrderProductDTO(OrderProduct orderProduct);
	OrderProduct toOrderProduct(OrderProductDTO orderProductDTO);
	List<OrderProductDTO> toOrderProductDTOList(List<OrderProduct> orderProducts);
	List<OrderProductDTO> toOrderProductDTOs(List<OrderProduct> orderProducts);
}

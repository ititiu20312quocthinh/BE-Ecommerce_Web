package org.sang.backendecommerce.mapper;

import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.sang.backendecommerce.dto.model.OrderDTO;
import org.sang.backendecommerce.model.Order;

@Mapper
public interface OrderMapper {
	OrderMapper INSTANCE = Mappers.getMapper(OrderMapper.class);
	OrderDTO toOrderDTO(Order order);
	Order toOrder(OrderDTO orderDTO);
	List<OrderDTO> toOrderDTOList(List<Order> orders);
}

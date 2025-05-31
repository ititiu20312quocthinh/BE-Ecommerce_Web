package org.sang.backendecommerce.service;

import java.util.List;
import java.util.Optional;
import org.sang.backendecommerce.dto.model.OrderDTO;

public interface OrderService {
	Optional<OrderDTO> createOrder(String address, String paymentMethod);
	List<OrderDTO> getUserOrders();
	Optional<OrderDTO> getOrderById(Long orderId);
}

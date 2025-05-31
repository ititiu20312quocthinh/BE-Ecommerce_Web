package org.sang.backendecommerce.service;

import java.util.List;
import java.util.Optional;
import org.sang.backendecommerce.dto.model.OrderProductDTO;
import org.sang.backendecommerce.model.CartProduct;
import org.sang.backendecommerce.model.Order;
import org.sang.backendecommerce.model.OrderProduct;

public interface OrderProductService {
	OrderProduct createOrderProduct(CartProduct cartProduct, Order order);
	OrderProduct createOrderProduct(Long productId, String name, String imageUrl, double price, int quantity, Order order);
	List<OrderProduct> getOrderProducts(Long id);
	Optional<OrderProductDTO> getOrderProduct(Long id);
	OrderProduct getOrderProductEntity(Long id);
}

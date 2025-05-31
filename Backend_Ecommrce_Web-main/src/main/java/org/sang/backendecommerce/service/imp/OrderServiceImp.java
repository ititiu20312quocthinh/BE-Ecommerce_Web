package org.sang.backendecommerce.service.imp;

import jakarta.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import org.sang.backendecommerce.dto.model.OrderDTO;
import org.sang.backendecommerce.dto.model.OrderProductDTO;
import org.sang.backendecommerce.mapper.OrderMapper;
import org.sang.backendecommerce.mapper.OrderProductMapper;
import org.sang.backendecommerce.model.Cart;
import org.sang.backendecommerce.model.CartProduct;
import org.sang.backendecommerce.model.Order;
import org.sang.backendecommerce.model.OrderProduct;
import org.sang.backendecommerce.model.User;
import org.sang.backendecommerce.repository.OrderRepository;
import org.sang.backendecommerce.service.CartService;
import org.sang.backendecommerce.service.OrderProductService;
import org.sang.backendecommerce.service.OrderService;
import org.sang.backendecommerce.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImp implements OrderService {
	private final OrderRepository orderRepository;
	private final CartService cartService;
	private final OrderProductService orderProductService;
	private final UserService userService;

	@Autowired
	public OrderServiceImp(OrderRepository orderRepository, CartService cartService, OrderProductService orderProductService, UserService userService) {
		this.orderRepository = orderRepository;
		this.cartService = cartService;
		this.orderProductService = orderProductService;
		this.userService = userService;
	}

	@Transactional
	@Override
	public Optional<OrderDTO> createOrder(String address, String paymentMethod) {
		Cart cart = cartService.getCartEntity();
		Set<CartProduct> cartProducts = cart.getCartProducts();
		if (cartProducts.isEmpty()) {
			throw new IllegalArgumentException("Cart is empty");
		}
		Order order = new Order(null, cart.getUserId(), 0.0, address, paymentMethod, null, new ArrayList<>());
		Double total = 0.0;
		for (CartProduct cartProduct : cartProducts) {
			OrderProduct orderProduct = orderProductService.createOrderProduct(cartProduct, order);
			if (orderProduct == null) {
				continue;
			}
			order.getOrderProducts().add(orderProduct);
			total += orderProduct.getPrice() * orderProduct.getQuantity();
		}
		order.setTotal(total);
		order = orderRepository.save(order);
		// cartService.clearCart();
		return Optional.of(
				orderDTOWithOrderProductDTOs(
						OrderMapper.INSTANCE.toOrderDTO(order)
				)
		);
	}

	private OrderDTO orderDTOWithOrderProductDTOs(OrderDTO orderDTO) {
		List<OrderProductDTO> orderProductDTOs =
				OrderProductMapper.INSTANCE.toOrderProductDTOs(
						orderProductService.getOrderProducts(orderDTO.getId())
				);
		orderDTO.setOrderProducts(orderProductDTOs);
		return orderDTO;
	}

	@Override
	public List<OrderDTO> getUserOrders() {
		User user = userService.getUserEntity();
		List<Order> orders = orderRepository.findByUserId(user.getId());
		List<OrderDTO> orderDTOs = new ArrayList<>();
		for (Order order : orders) {
			orderDTOs.add(
					orderDTOWithOrderProductDTOs(
							OrderMapper.INSTANCE.toOrderDTO(order)
					)
			);
		}
		return orderDTOs;
	}

	@Override
	public Optional<OrderDTO> getOrderById(Long orderId) {
		Order order = orderRepository.findById(orderId).orElse(null);
		if (order == null) {
			throw new IllegalArgumentException("Order does not exist");
		}
		return Optional.of(
				orderDTOWithOrderProductDTOs(
						OrderMapper.INSTANCE.toOrderDTO(order)
				)
		);
	}
}

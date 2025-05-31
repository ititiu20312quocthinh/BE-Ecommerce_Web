package org.sang.backendecommerce.controller;

import java.util.List;
import org.sang.backendecommerce.dto.model.OrderDTO;
import org.sang.backendecommerce.dto.request.OrderRequestDTO;
import org.sang.backendecommerce.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/v1")
public class OrderController {
	private final OrderService orderService;

	@Autowired
	public OrderController(OrderService orderService) {
		this.orderService = orderService;
	}

	@PostMapping("/order")
	public OrderDTO createOrder(@RequestBody OrderRequestDTO orderRequestDTO) {
		if (orderRequestDTO == null || orderRequestDTO.getAddress() == null || orderRequestDTO.getPaymentMethod() == null) {
			throw new IllegalArgumentException("Address and payment method are required");
		}
		return orderService.
				createOrder(orderRequestDTO.getAddress(), orderRequestDTO.getPaymentMethod())
				.orElseThrow(() -> new RuntimeException("Order could not be created"));
	}

	@GetMapping("/orders")
	public List<OrderDTO> getUserOrders() {
		return orderService.getUserOrders();
	}

	@GetMapping("/order/{orderId}")
	public OrderDTO getOrderById(@PathVariable Long orderId) {
		if (orderId == null) {
			throw new IllegalArgumentException("Order id is required");
		}
		return orderService.getOrderById(orderId).orElseThrow(() -> new RuntimeException("Order not found"));
	}
}

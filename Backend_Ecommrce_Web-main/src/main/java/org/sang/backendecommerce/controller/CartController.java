package org.sang.backendecommerce.controller;

import org.sang.backendecommerce.dto.model.CartDTO;
import org.sang.backendecommerce.dto.request.CartRequestDTO;
import org.sang.backendecommerce.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/v1/cart")
public class CartController {
	private final CartService cartService;

	@Autowired
	public CartController(CartService cartService) {
		this.cartService = cartService;
	}

	@GetMapping
	public CartDTO getCart() {
		return cartService.getCart().orElseThrow(() -> new RuntimeException("Cart not found"));
	}

	@PostMapping("/{productId}")
	public CartDTO addProductToCart(@PathVariable Long productId) {
		return cartService.addProductToCart(productId)
				.orElseThrow(() -> new RuntimeException("Product not found"));
	}

	@PutMapping
	public CartDTO updateProductQuantityInCart(@RequestBody CartRequestDTO cartRequestDTO) {
		if (cartRequestDTO == null || cartRequestDTO.getProductId() == null) {
			throw new IllegalArgumentException("Product id and quantity are required");
		}
		return cartService.updateProductQuantityInCart(cartRequestDTO.getProductId(), cartRequestDTO.getQuantity())
				.orElseThrow(() -> new RuntimeException("Product not found"));
	}

	@DeleteMapping("/{productId}")
	public CartDTO removeProductFromCart(@PathVariable Long productId) {
		return cartService.removeProductFromCart(productId)
				.orElseThrow(() -> new RuntimeException("Product not found"));
	}

	@DeleteMapping
	public boolean clearCart() {
		return cartService.clearCart();
	}
}

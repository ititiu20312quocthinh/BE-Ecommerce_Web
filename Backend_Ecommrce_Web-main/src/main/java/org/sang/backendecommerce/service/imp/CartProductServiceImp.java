package org.sang.backendecommerce.service.imp;

import java.util.List;
import java.util.Optional;
import org.sang.backendecommerce.dto.model.ProductDTO;
import org.sang.backendecommerce.model.Cart;
import org.sang.backendecommerce.model.CartProduct;
import org.sang.backendecommerce.repository.CartProductRepository;
import org.sang.backendecommerce.repository.CartRepository;
import org.sang.backendecommerce.service.CartProductService;
import org.sang.backendecommerce.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CartProductServiceImp implements CartProductService {
	private final CartProductRepository cartProductRepository;
	private final CartRepository cartRepository;
	private final ProductService productService;

	@Autowired
	public CartProductServiceImp(CartProductRepository cartProductRepository, CartRepository cartRepository, ProductService productService) {
		this.cartProductRepository = cartProductRepository;
		this.cartRepository = cartRepository;
		this.productService = productService;
	}
	@Override
	public Optional<CartProduct> createCartProduct(Long productId, Long cartId) {
		if (productId == null || cartId == null)
			throw new IllegalArgumentException("Product and cart ids must be provided");
		ProductDTO productDTO = productService.getProduct(productId).orElse(null);
		if (productDTO == null)
			throw new IllegalArgumentException("Product with this id does not exist");
		Cart cart = cartRepository.findById(cartId).orElse(null);
		CartProduct cartProduct = new CartProduct(
				null,
				productId,
				productDTO.getName(),
				productDTO.getImageUrl(),
				productDTO.getPrice(),
				1,
				cart
		);
		return Optional.of(cartProductRepository.save(cartProduct));
	}

	@Override
	public Optional<CartProduct> getCartProduct(Long productId, Long cartId) {
		if (productId == null || cartId == null)
			throw new IllegalArgumentException("Product and cart ids must be provided");
		return Optional.ofNullable(cartProductRepository.findByProductIdAndCartId(productId, cartId));
	}

	@Override
	public List<CartProduct> getCartProducts(Long cartId) {
		if (cartId == null)
			throw new IllegalArgumentException("Cart id must be provided");
		return cartProductRepository.findByCartId(cartId);
	}

	@Override
	public Optional<CartProduct> updateCartProduct(CartProduct cartProduct, int quantity) {
		if (cartProduct == null)
			throw new IllegalArgumentException("Cart product must be provided");
		cartProduct.setQuantity(quantity);
		return Optional.of(cartProductRepository.save(cartProduct));
	}

	@Override
	public Optional<CartProduct> updateCartProduct(Long productId, int quantity, Long cartId) {
		return updateCartProduct(getCartProduct(productId, cartId).orElse(null), quantity);
	}

	@Override
	public boolean removeCartProduct(CartProduct cartProduct) {
		if (cartProduct == null)
			return false;
		cartProductRepository.deleteById(cartProduct.getId());
		return true;
	}

	@Override
	public boolean removeCartProduct(Long productId, Long cartId) {
		return removeCartProduct(getCartProduct(productId, cartId).orElse(null));
	}
}

package org.sang.backendecommerce.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name = "cart_products")
public class CartProduct {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false)
	private Long productId;

	@Column(nullable = false)
	private String name;

	@Column(nullable = false)
	private String imageUrl;

	@Column(nullable = false)
	private double price;

	@Column(nullable = false)
	private int quantity;

	@ManyToOne
	@JoinColumn(name = "cart_id", nullable = false)
	private Cart cart;

	public CartProduct() {
	}

	public CartProduct(Long id, Long productId, String name, String imageUrl, double price, int quantity, Cart cart) {
		this.id = id;
		this.productId = productId;
		this.name = name;
		this.imageUrl = imageUrl;
		this.price = price;
		this.quantity = quantity;
		this.cart = cart;
	}

}

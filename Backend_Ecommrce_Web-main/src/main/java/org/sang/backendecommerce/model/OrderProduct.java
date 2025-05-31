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
@Table(name = "order_products")
public class OrderProduct {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false, updatable = false)
	private Long productId;

	@Column(nullable = false, updatable = false)
	private String name;

	@Column(nullable = false, updatable = false)
	private String imageUrl;

	@Column(nullable = false, updatable = false)
	private Double price;

	@Column(nullable = false, updatable = false)
	private int quantity;

	@ManyToOne
	@JoinColumn(name = "order_id", nullable = false, updatable = false)
	private Order order;

	public OrderProduct() {
	}

	public OrderProduct(Long id, Long productId, String name, String imageUrl, Double price, int quantity, Order order) {
		this.id = id;
		this.productId = productId;
		this.name = name;
		this.imageUrl = imageUrl;
		this.price = price;
		this.quantity = quantity;
		this.order = order;
	}

}
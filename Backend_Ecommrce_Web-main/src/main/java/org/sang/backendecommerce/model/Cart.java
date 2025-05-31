package org.sang.backendecommerce.model;

import jakarta.persistence.*;
import java.util.Set;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name = "carts")
public class Cart {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false, unique = true)
	private Long userId;

	@Column(nullable = false)
	private Double total;

	@OneToMany(mappedBy = "cart", cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
	private Set<CartProduct> cartProducts;

	public Cart() {
	}

	public Cart(Long id, Long userId, Double total, Set<CartProduct> cartProducts) {
		this.id = id;
		this.userId = userId;
		this.total = total;
		this.cartProducts = cartProducts;
	}

}

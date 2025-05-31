package org.sang.backendecommerce.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;
import java.util.List;

@Setter
@Getter
@Entity
@Table(name = "orders")
public class Order {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false, updatable = false)
	private Long userId;

	@Column(nullable = false, updatable = false)
	private Double total;

	@Column(nullable = false, updatable = false)
	private String address;

	@Column(nullable = false, updatable = false)
	private String paymentMethod;

	@CreationTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	@Column(nullable = false, updatable = false)
	private Date date;

	@OneToMany(mappedBy = "order", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private List<OrderProduct> orderProducts;

	public Order() {
	}

	public Order(Long id, Long userId, Double total, String address, String paymentMethod, Date date, List<OrderProduct> orderProducts) {
		this.id = id;
		this.userId = userId;
		this.total = total;
		this.address = address;
		this.paymentMethod = paymentMethod;
		this.date = date;
		this.orderProducts = orderProducts;
	}

}

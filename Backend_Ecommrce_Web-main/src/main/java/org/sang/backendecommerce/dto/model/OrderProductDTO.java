package org.sang.backendecommerce.dto.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderProductDTO {
	private Long id;
	private Long productId;
	private String name;
	private String imageUrl;
	private Double price;
	private int quantity;
	private OrderDTO order;

}

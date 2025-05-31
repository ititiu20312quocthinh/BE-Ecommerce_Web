package org.sang.backendecommerce.dto.model;

import java.util.Set;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CartDTO {
	private Long id;
	private Long userId;
	private Double total;
	private Set<CartProductDTO> cartProducts;

}

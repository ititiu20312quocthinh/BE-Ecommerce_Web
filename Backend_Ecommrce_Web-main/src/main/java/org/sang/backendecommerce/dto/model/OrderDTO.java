package org.sang.backendecommerce.dto.model;

import java.util.Date;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderDTO {
	private Long id;
	private Long userId;
	private Double total;
	private String address;
	private String paymentMethod;
	private Date date;
	private List<OrderProductDTO> orderProducts;

}

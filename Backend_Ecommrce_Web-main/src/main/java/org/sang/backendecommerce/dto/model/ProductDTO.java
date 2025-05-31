package org.sang.backendecommerce.dto.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductDTO {
	private Long id;
	private String name;
	private String description;
	private double price;
	private String imageUrl;
	private int stock;

	public ProductDTO updateProduct(ProductDTO newProductDTO) {
		if(newProductDTO.getName() != null) {
			this.setName(newProductDTO.getName());
		}
		if(newProductDTO.getDescription() != null) {
			this.setDescription(newProductDTO.getDescription());
		}
		if(newProductDTO.getPrice() != 0) {
			this.setPrice(newProductDTO.getPrice());
		}
		if(newProductDTO.getImageUrl() != null) {
			this.setImageUrl(newProductDTO.getImageUrl());
		}
		if(newProductDTO.getStock() != 0) {
			this.setStock(newProductDTO.getStock());
		}
		return this;
	}
}

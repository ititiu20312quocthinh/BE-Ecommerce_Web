package org.sang.backendecommerce.service;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import org.sang.backendecommerce.dto.model.ProductDTO;
import org.sang.backendecommerce.model.Product;

public interface ProductService {
	Optional<ProductDTO> addProduct(ProductDTO productDTO);
	List<ProductDTO> getProducts();
	Optional<ProductDTO> getProduct(Long id);
	Optional<Product> getProductEntity(Long id);
	Set<ProductDTO> getProductsBySearch(String searchString);
	Optional<ProductDTO> updateProduct(Product product);
	Optional<ProductDTO> updateProduct(ProductDTO productDTO);
	boolean deleteProduct(Long id);
}

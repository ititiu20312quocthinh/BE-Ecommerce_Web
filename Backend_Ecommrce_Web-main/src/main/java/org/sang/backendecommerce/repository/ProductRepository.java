package org.sang.backendecommerce.repository;

import java.util.Set;
import org.sang.backendecommerce.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
	Set<Product> findByNameContainingIgnoreCase(String searchString);
	Set<Product> findByDescriptionContainingIgnoreCase(String searchString);
}

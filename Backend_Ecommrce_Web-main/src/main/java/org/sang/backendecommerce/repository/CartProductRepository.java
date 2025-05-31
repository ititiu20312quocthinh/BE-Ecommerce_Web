package org.sang.backendecommerce.repository;

import java.util.List;
import org.sang.backendecommerce.model.CartProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartProductRepository extends JpaRepository<CartProduct, Long> {
	CartProduct findByProductIdAndCartId(Long productId, Long cartId);
	List<CartProduct> findByCartId(Long cartId);
}

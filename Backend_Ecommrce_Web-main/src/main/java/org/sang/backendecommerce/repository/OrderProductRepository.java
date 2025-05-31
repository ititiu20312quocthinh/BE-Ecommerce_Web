package org.sang.backendecommerce.repository;

import java.util.List;
import org.sang.backendecommerce.model.OrderProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderProductRepository extends JpaRepository<OrderProduct, Long> {
	List<OrderProduct> findByOrderId(Long id);
}

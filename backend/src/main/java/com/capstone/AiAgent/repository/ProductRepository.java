package com.capstone.AiAgent.repository;

import com.capstone.AiAgent.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

@Repository
public interface ProductRepository extends JpaRepository<Product, UUID> {

    @Query("""
        SELECT p FROM Product p
        WHERE (:query IS NULL OR :query = ''
               OR LOWER(p.name) LIKE LOWER(CONCAT('%', :query, '%'))
               OR LOWER(p.category) LIKE LOWER(CONCAT('%', :query, '%')))
          AND (:maxPrice IS NULL OR p.price <= :maxPrice)
        ORDER BY p.rating DESC
        """)
    List<Product> search(@Param("query") String query, @Param("maxPrice") BigDecimal maxPrice);
}

package com.fastcampus.springboottoyboard.jpa_repository;

import com.fastcampus.springboottoyboard.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    @Query(value = "SELECT p.name, c.member.id, ms.level, s.nationality " +
            "FROM Product p " +
            "LEFT JOIN Cart c ON p.id = c.product.id " +
            "LEFT JOIN Member m ON c.product.id = m.id " +
            "LEFT JOIN Membership ms ON m.id = ms.member.id " +
            "LEFT JOIN Ship s ON ms.ship.id = s.id " +
            "ORDER BY ms.level, p.name")
    List<Object[]> getAll();
}

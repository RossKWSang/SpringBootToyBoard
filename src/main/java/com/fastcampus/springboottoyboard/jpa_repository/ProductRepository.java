package com.fastcampus.springboottoyboard.jpa_repository;

import com.fastcampus.springboottoyboard.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {

}

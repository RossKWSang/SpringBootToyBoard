package com.fastcampus.springboottoyboard.service;

import com.fastcampus.springboottoyboard.domain.Product;
import com.fastcampus.springboottoyboard.dto.ProductJoinResult;
import com.fastcampus.springboottoyboard.jdbc_repository.JdbcProductRepository;
import com.fastcampus.springboottoyboard.jpa_repository.ProductJpaRepository;
import com.fastcampus.springboottoyboard.jpa_repository.ProductRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
public class ProductJoinResultService {

    private final JdbcProductRepository jdbcProductRepository;
    private final ProductJpaRepository productJpaRepository;
    private final ProductRepository productRepository;

    ProductJoinResultService(
            JdbcProductRepository jdbcProductRepository,
            ProductJpaRepository productJpaRepository,
            ProductRepository productRepository
    ) {
        this.jdbcProductRepository = jdbcProductRepository;
        this.productJpaRepository = productJpaRepository;
        this.productRepository = productRepository;
    }

    @Transactional
    public List<ProductJoinResult> getAllByJDBC() {
        return jdbcProductRepository.getAll();
    }

    @Transactional
    public List<Object[]> getAllByJPA() {
        return productJpaRepository.getAllByJpa();
    }

    @Transactional
    public List<Object[]> getAllBySpringDataJPA() {
        return productRepository.getAll();
    }
}

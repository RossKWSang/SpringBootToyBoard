package com.fastcampus.springboottoyboard.service;

import com.fastcampus.springboottoyboard.dto.ProductJoinResult;
import com.fastcampus.springboottoyboard.jdbc_repository.JdbcProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductJoinResultService {

    private final JdbcProductRepository jdbcProductRepository;

    ProductJoinResultService(
            JdbcProductRepository jdbcProductRepository
    ) {
        this.jdbcProductRepository = jdbcProductRepository;
    }

    public List<ProductJoinResult> getAllByJDBC() {
        return jdbcProductRepository.getAll();
    }
}

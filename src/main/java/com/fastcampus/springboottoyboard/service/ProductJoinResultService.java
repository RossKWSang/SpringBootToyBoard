package com.fastcampus.springboottoyboard.service;

import com.fastcampus.springboottoyboard.dto.ProductJoinResult;
import com.fastcampus.springboottoyboard.jdbc_repository.JdbcProductRepository;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
public class ProductJoinResultService {

    private final JdbcProductRepository jdbcProductRepository;

    ProductJoinResultService(
            JdbcProductRepository jdbcProductRepository
    ) {
        this.jdbcProductRepository = jdbcProductRepository;
    }

    List<ProductJoinResult> getAllByJDBC() throws SQLException {
        return jdbcProductRepository.getAll();
    }
}

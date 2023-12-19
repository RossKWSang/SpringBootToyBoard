package com.fastcampus.springboottoyboard.jdbc_repository;

import com.fastcampus.springboottoyboard.domain.Article;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.ArrayList;
import java.util.List;

public class JdbcArticleRepository {
    public List<Article> findAll() {
        return new ArrayList<>();
    }
}

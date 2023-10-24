package com.fastcampus.springboottoyboard.repository;

import com.fastcampus.springboottoyboard.domain.Article;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArticleRepository extends JpaRepository<Article, Long> {
}
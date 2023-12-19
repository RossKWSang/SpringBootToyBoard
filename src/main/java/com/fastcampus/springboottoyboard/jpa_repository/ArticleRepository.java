package com.fastcampus.springboottoyboard.jpa_repository;

import com.fastcampus.springboottoyboard.domain.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Service;

@Service
@RepositoryRestResource
public interface ArticleRepository extends JpaRepository<Article, Long> {
}

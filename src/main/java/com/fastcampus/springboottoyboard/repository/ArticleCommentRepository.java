package com.fastcampus.springboottoyboard.repository;

import com.fastcampus.springboottoyboard.domain.ArticleComment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArticleCommentRepository extends JpaRepository<ArticleComment, Long> {
}

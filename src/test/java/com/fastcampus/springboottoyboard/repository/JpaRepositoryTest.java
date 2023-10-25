package com.fastcampus.springboottoyboard.repository;

import com.fastcampus.springboottoyboard.config.JpaConfig;
import com.fastcampus.springboottoyboard.domain.Article;
import com.fastcampus.springboottoyboard.repository.ArticleCommentRepository;
import com.fastcampus.springboottoyboard.repository.ArticleRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.ActiveProfiles;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@ActiveProfiles("testdb")
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@DisplayName("JPA 연결 테스트")
@Import(JpaConfig.class)
@DataJpaTest
class JpaRepositoryTest {
    private final ArticleRepository articleRepository;
    private final ArticleCommentRepository articleCommentRepository;

    public JpaRepositoryTest(
            @Autowired ArticleRepository articleRepository,
            @Autowired ArticleCommentRepository articleCommentRepository
    ) {
        this.articleRepository = articleRepository;
        this.articleCommentRepository = articleCommentRepository;
    }

    @DisplayName("select 테스트")
    @Test
    void givenTestData_whenSelecting_thenWorksFine() {
        // Given

        // When
        List<Article> articles = articleRepository.findAll();

        // Then
        assertThat(articles)
                .isNotNull()
                .hasSize(0);
    }

    @DisplayName("insert 테스트")
    @Test
    void givenTestData_whenInserting_thenWorksFine() {
        // Given
        long previousCount = articleRepository.count();
        Article savedArticle = articleRepository.save(Article.of("new article", "new content", "#spring"));
        assertThat(articleRepository.count())
                .isEqualTo(previousCount + 1);
    }


//    @DisplayName("update 테스트")
//    @Test
//    void givenTestData_whenUpdating_thenWorksFine() {
//        // Given
//        Article article = articleRepository.findById(1L).orElseThrow();
//        String updateHashtag = "#springboot";
//        article.setHashtag(updateHashtag);
//
//        Article savedArticle = articleRepository.save(article);
//
//        assertThat(savedArticle).hasFieldOrPropertyWithValue("hashtag", updateHashtag);
//    }

}
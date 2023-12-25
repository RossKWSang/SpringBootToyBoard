package com.fastcampus.springboottoyboard.jpa_repository;

import com.fastcampus.springboottoyboard.domain.Product;
import com.fastcampus.springboottoyboard.dto.ProductJoinResult;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.List;

@Repository
public class ProductJpaRepository {

    @PersistenceContext
    private EntityManager entityManager;

    private final JPAQueryFactory queryFactory;

    public ProductJpaRepository(EntityManager em) {
        this.queryFactory = new JPAQueryFactory(em);
    }


    public List<Object[]> getAllByJpa() {
        String nativeQuery = "SELECT p.name, c.member_id, ms.level, s.nationality " +
                "FROM data_test.product p " +
                "LEFT JOIN data_test.cart c ON p.id = c.product_id " +
                "LEFT JOIN data_test.member m ON c.product_id = m.id " +
                "LEFT JOIN data_test.membership ms ON m.id = ms.member_id " +
                "LEFT JOIN data_test.ship s ON ms.ship_id = s.id " +
                "ORDER BY ms.level, p.name";

        List results = entityManager.createNativeQuery(nativeQuery).getResultList();
        return results;
    }
}

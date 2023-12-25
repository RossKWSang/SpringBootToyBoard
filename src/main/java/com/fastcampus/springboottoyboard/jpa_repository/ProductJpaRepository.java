package com.fastcampus.springboottoyboard.jpa_repository;

import com.fastcampus.springboottoyboard.domain.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.List;

@Repository
public class ProductJpaRepository {

    @Autowired
    EntityManager em;

    public List<Product> getAll() {
        return new ArrayList<>();

//                em.createQuery("SELECT p FROM Product p LEFT JOIN FETCH p.cartList c LEFT JOIN FETCH f.categories c"
//                + " order by a.lastName,a.firstName,f.title,c.name", Actor.class).getResultList();
    }
}

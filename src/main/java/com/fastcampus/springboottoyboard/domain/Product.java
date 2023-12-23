package com.fastcampus.springboottoyboard.domain;

import lombok.Getter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Table(name="product")
@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="name", nullable=false, length=50)
    private String name;

    @Column(name="price", nullable=false)
    private Integer price;

    @OneToMany(mappedBy="product")
    private List<Cart> cartList = new ArrayList<>();
}

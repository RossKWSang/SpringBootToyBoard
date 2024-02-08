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

    @Getter
    @Column(name="name", nullable=false, length=50)
    private String name;

    @Column(name="price", nullable=false)
    private String price;

    @OneToMany(mappedBy="product")
    private List<Cart> cartList = new ArrayList<>();

    public Product() {}

    public Product(String name, String price) {
        this.name = name;
        this.price = price;
    }
}

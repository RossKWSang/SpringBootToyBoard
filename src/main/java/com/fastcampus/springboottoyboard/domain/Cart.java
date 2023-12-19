package com.fastcampus.springboottoyboard.domain;

import lombok.Getter;

import javax.persistence.*;

@Getter
@Table(name="cart")
@Entity
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
}

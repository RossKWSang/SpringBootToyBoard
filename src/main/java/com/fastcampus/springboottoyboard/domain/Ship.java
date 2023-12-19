package com.fastcampus.springboottoyboard.domain;

import lombok.Getter;

import javax.persistence.*;

@Getter
@Table(name="ship")
@Entity
public class Ship {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="nationality", nullable=false, length=50)
    private String nationality;

    @Column(name="displacement", nullable=false)
    private Integer displacement;
}

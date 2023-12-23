package com.fastcampus.springboottoyboard.domain;

import lombok.Getter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Table(name="member")
@Entity
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="name", nullable=false, length=50)
    private String name;

    @Column(name="age", nullable=false)
    private Integer age;

    @Column(name="email", nullable=false, length=50)
    private String email;

    @OneToMany(mappedBy="member")
    private List<Cart> cartList = new ArrayList<>();

    @OneToMany(mappedBy="member")
    private List<Membership> membershipList = new ArrayList<>();
}

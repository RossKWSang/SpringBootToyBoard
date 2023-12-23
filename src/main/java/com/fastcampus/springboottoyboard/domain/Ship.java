package com.fastcampus.springboottoyboard.domain;

import lombok.Getter;
tus
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Table(name="ship")
@Entity
public class Ship {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="nationality", nullable=false, length=200)
    private String nationality;

    @Column(name="displacement", nullable=false)
    private Integer displacement;

    @OneToMany(mappedBy="ship")
    private List<Membership> membershipList = new ArrayList<>();
}

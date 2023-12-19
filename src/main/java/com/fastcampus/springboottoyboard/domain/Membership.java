package com.fastcampus.springboottoyboard.domain;

import lombok.Getter;

import javax.persistence.*;

@Getter
@Table(name="membership")
@Entity
public class Membership {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch =FetchType.LAZY)
    @JoinColumn(name = "member_id", columnDefinition = "bigint", foreignKey = @ForeignKey(value = ConstraintMode.NO_CONSTRAINT))
    private Member member;

}

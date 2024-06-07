package com.fastcampus.springboottoyboard.order;

import com.fastcampus.springboottoyboard.discount.DiscountPolicy;
import com.fastcampus.springboottoyboard.member.Member;
import com.fastcampus.springboottoyboard.member.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OrderServiceImpl implements OrderService {

    // private final MemberRepository memberRepository = new MemoryMemberRepository();

    // OCP, DIP 위반 사례
    // private final DiscountPolicy discountPolicy = new FixDiscountPolicy();
    // private final DiscountPolicy discountPolicy = new RateDiscountPolicy();

    // 철저하게 인터페이스에만 의존한다 -> OCP, DIP 준수 사례
    private final MemberRepository memberRepository;
    private final DiscountPolicy discountPolicy;

    @Autowired
    public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);

        // 단일 책임 원칙이 잘 지켜지고 있다.
        int discountPrice = discountPolicy.discount(member, itemPrice);

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }

    public MemberRepository getMemberRepository() {
        return memberRepository;
    }

}

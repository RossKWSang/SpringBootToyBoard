package com.fastcampus.springboottoyboard.order;

import com.fastcampus.springboottoyboard.discount.DiscountPolicy;
import com.fastcampus.springboottoyboard.discount.FixDiscountPolicy;
import com.fastcampus.springboottoyboard.member.Member;
import com.fastcampus.springboottoyboard.member.MemberRepository;
import com.fastcampus.springboottoyboard.member.MemoryMemberRepository;

public class OrderServiceImpl implements OrderService {

    private final MemberRepository memberRepository = new MemoryMemberRepository();
    private final DiscountPolicy discountPolicy = new FixDiscountPolicy();

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);

        // 단일 책임 원칙이 잘 지켜지고 있다.
        int discountPrice = discountPolicy.discount(member, itemPrice);

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }
}

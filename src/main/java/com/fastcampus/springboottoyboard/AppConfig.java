package com.fastcampus.springboottoyboard;

import com.fastcampus.springboottoyboard.discount.DiscountPolicy;
import com.fastcampus.springboottoyboard.discount.RateDiscountPolicy;
import com.fastcampus.springboottoyboard.member.MemberService;
import com.fastcampus.springboottoyboard.member.MemberServiceImpl;
import com.fastcampus.springboottoyboard.member.MemoryMemberRepository;
import com.fastcampus.springboottoyboard.order.OrderService;
import com.fastcampus.springboottoyboard.order.OrderServiceImpl;


/** 애플리케이션의 실제 동작에 필요한 "구현 객체를 생성"한다.
*   객체의 인스턴스의 참조를 "생성자를 통해서 주입(연결)"해준다.
* */
public class AppConfig {

    private MemoryMemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

    private DiscountPolicy discountPolicy() {
        return new RateDiscountPolicy();
    }

    public MemberService memberService() {
        return new MemberServiceImpl(memberRepository());
    }

    public OrderService orderService() {
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }
}


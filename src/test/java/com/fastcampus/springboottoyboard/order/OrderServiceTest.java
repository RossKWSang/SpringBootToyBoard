package com.fastcampus.springboottoyboard.order;

import com.fastcampus.springboottoyboard.member.Grade;
import com.fastcampus.springboottoyboard.member.Member;
import com.fastcampus.springboottoyboard.member.MemberService;
import com.fastcampus.springboottoyboard.member.MemberServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class OrderServiceTest {

    OrderService orderService = new OrderServiceImpl();
    MemberService memberService = new MemberServiceImpl();

    @Test
    void createOrder() {
        // given
        Long memberId = 1L;
        Member member = new Member(memberId, "memberA", Grade.VIP);
        memberService.join(member);

        // when
        Order order = orderService.createOrder(member.getId(), "itemA", 10000);

        // then
        Assertions.assertThat(order.getMemberId()).isEqualTo(memberId);
    }
}

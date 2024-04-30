package com.fastcampus.springboottoyboard.discount;

import com.fastcampus.springboottoyboard.member.Member;

public interface DiscountPolicy {

    /** @return 할인 대상 금액
    *
    * */
    int discount(Member member, int price);
}

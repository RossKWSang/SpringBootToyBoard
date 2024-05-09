package com.fastcampus.springboottoyboard;

import com.fastcampus.springboottoyboard.member.Grade;
import com.fastcampus.springboottoyboard.member.Member;
import com.fastcampus.springboottoyboard.member.MemberService;
import com.fastcampus.springboottoyboard.member.MemberServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MemberApp {
    public static void main(String[] args) {
//        AppConfig appConfig = new AppConfig();
//        MemberService memberService = appConfig.memberService();

        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        MemberService memberService = applicationContext.getBean("memberService", MemberService.class);

        Member member = new Member(1L, "memberA", Grade.VIP);
        memberService.join(member);

        Member findMember = memberService.findMember(1L);
        System.out.println("mew member = " + member.getName());
        System.out.println("find member = " + findMember.getName());
    }
}

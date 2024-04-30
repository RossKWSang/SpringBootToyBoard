package com.fastcampus.springboottoyboard.member;

public interface MemberService {

    void join(Member member);

    Member findMember(Long memberId);
}

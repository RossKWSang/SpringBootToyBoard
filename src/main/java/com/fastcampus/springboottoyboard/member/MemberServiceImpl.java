package com.fastcampus.springboottoyboard.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MemberServiceImpl implements MemberService {

    // 이 부분이 문제가 된다.
    // MemberRepository는 인터페이스에 의존한다고 해도 실제로 주입밭는 부분은 구현체에 의존하고 있다.
    // private final MemberRepository memberRepository = new MemoryMemberRepository();

    private final MemberRepository memberRepository;

    @Autowired // 스프링은 자동으로 의존관계를 지니는 컴포넌트를 불러온다. @Component와 쌍으로 사용
    public MemberServiceImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Override
    public void join(Member member) {
        memberRepository.save(member);
    }

    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId);
    }

    // 테스트 용
    public MemberRepository getMemberRepository() {
        return memberRepository;
    }
}

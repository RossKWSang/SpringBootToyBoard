package com.fastcampus.springboottoyboard.member;

public class MemberServiceImpl implements MemberService {

    // 이 부분이 문제가 된다.
    // MemberRepository는 인터페이스에 의존한다고 해도 실제로 주입밭는 부분은 구현체에 의존하고 있다.
    private final MemberRepository memberRepository = new MemoryMemberRepository();

    @Override
    public void join(Member member) {
        memberRepository.save(member);
    }

    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId);
    }
}

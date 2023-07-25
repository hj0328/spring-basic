package hello.core.member;

public class MemberServiceImpl implements MemberSerivce {

    private final MemberRepository memberRepository;

    // 싱글톤 Test를 위해 임시 추가한 코드. 실무에서는 이러면 안됨
    public MemberRepository getMemberRepository() {
        return memberRepository;
    }

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
}

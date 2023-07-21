package hello.core.member;

import hello.core.AppConfig;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MemberSerivceTest {

    MemberSerivce memberSerivce;

    @BeforeEach
    void beforeEach() {
        AppConfig appConfig = new AppConfig();
        memberSerivce = appConfig.memberService();
    }

    @Test
    void join() {
        // given
        Member member = new Member(1L, "memberA", Grade.VIP);

        // when
        memberSerivce.join(member);
        Member findMember = memberSerivce.findMember(member.getId());

        // then
        Assertions.assertThat(member).isEqualTo(findMember);
    }

    @Test
    void findMember() {
    }
}
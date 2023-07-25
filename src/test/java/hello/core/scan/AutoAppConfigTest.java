package hello.core.scan;

import hello.core.AutoAppConfig;
import hello.core.member.MemberSerivce;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AutoAppConfigTest {

    @Test
    void basicScan() {
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AutoAppConfig.class);
        MemberSerivce memberSerivce = ac.getBean(MemberSerivce.class);
        Assertions.assertThat(memberSerivce).isInstanceOf(MemberSerivce.class);

        // 로그를 보면 ClassPathBeanDefinitionScanner 로 등록이 되는 것을 알 수 있다.
        // org.springframework.context.annotation.ClassPathBeanDefinitionScanner..
        // - Identified candidate component class:
    }
}

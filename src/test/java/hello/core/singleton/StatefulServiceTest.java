package hello.core.singleton;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

public class StatefulServiceTest {

    @Test
    void statefulServiceSingleton() {
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(TestConfig.class);
        StatefulService statefulService = ac.getBean(StatefulService.class);

        // ThreadA: A사용자 10000원 주문
        statefulService.order("userA", 10000);

        // ThreadB: B사용자 20000원 주문
        statefulService.order("userA", 20000);

        // 간단하게 표현했지만 쓰레드 A, B가 거의 동시에 들어오는 상황을 가정
        // 인스턴스 변수 price는 stateful하기 때문에 서로다른 쓰레드에 영향을 받는다.
        // 해당 예제는 간단하지만, 실무에서 상속관계, 설계의 복잡성에 따라서 해당 문제가 발생하면 해결하기 어려우니 주의해야 한다.
        System.out.println("price=" + statefulService.getPrice());
        Assertions.assertThat(statefulService.getPrice()).isEqualTo(20000);
    }

    static class TestConfig {
        @Bean
        public StatefulService statefulService() {
            return new StatefulService();
        }
    }
}

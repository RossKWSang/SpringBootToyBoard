package com.fastcampus.springboottoyboard.singleton;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;


class StatefulServiceTest {

    @Test
    @DisplayName("싱글톤 패턴은 Stateless하게 설계되어야함")
    void statefulServiceSingleton() {
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(TestConfig.class);

        StatefulService statefulService1 = ac.getBean(StatefulService.class);
        StatefulService statefulService2 = ac.getBean(StatefulService.class);

        // ThreadA : A 사용자 10000원 주문
        // statefulService1.order("userA", 10000);

        // ThreadB : B 사용자 20000원 주문
        // statefulService2.order("userB", 20000);

        // 실무에서 이런 장애는 잡기도 어렵다 ...
        // System.out.println("price = " + price1);

        Assertions.assertThat(statefulService1.order(10000)).isEqualTo(10000);
    }

    static class TestConfig {

        @Bean
        public StatefulService statefulService() {
            return new StatefulService();
        }

    }

}
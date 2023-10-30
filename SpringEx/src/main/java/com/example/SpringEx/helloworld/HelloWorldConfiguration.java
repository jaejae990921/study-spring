package com.example.SpringEx.helloworld;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

// record : getter, setter, 생성자 등을 자동으로 생성
record Person(String name, int age) {}

record Address(String address, int postcode) {}

record Information(String name, int age, Address address) {}

//Configuration: 빈(Bean) 정의를 포함하는 클래스
@Configuration
public class HelloWorldConfiguration {
    @Bean
    public String name() {
        return "Simson";
    }

    @Bean
    public int age() {
        return 25;
    }

    @Bean
    public Person person() {
        return new Person("hard coding", 30); // 하드코딩
    }

    @Bean
    public Person person2() {
        return new Person(name(), age()); // Bean 재사용
    }

    @Bean(name = "myAdd") // context.getBean("이름"); 에서 name을 변경할 수 있음
    public Address address() {
        return new Address("Seoul Mapo", 9125);
    }

    @Bean
    @Primary
    public Information info(String name, int age, Address myAdd) {
        return new Information(name, age, myAdd);
    }

    @Bean
    @Primary // Address.class로 접근할 때, 값이 많을 경우 어떤 것을 가져올지 설정해줌 // Address 가져올 때도 얘가 가져와짐
    public Address address2() {
        return new Address("Korea PT", 123456);
    }

    @Bean
    @Qualifier("addressQualifier")
    public Address adress3() {
        return new Address("Ulsan", 789789);
    }

    @Bean
    public Information info2(String name, int age, @Qualifier("addressQualifier") Address myAddress) {
        return new Information(name, age, myAddress);
    }
}

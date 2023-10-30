package com.example.SpringEx.helloworld;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class HelloWorld {
    public static void main(String[] args) {
        // 스프링 컨텍스트를 실행하는 단계
        var context = new AnnotationConfigApplicationContext(HelloWorldConfiguration.class);

        // 스프링 프레임워크가 관리하도록 설정
        // 스프링에서 관리하는것은 무엇이든 Bean이 될 수 있다.
        System.out.println(context.getBean("name"));
        System.out.println(context.getBean("age"));
        System.out.println(context.getBean("person"));
        System.out.println(context.getBean("person2"));
        // System.out.println(context.getBean("address")); // 이름을 커스텀 했기 때문에 더이상 못쓰게 됨
        System.out.println(context.getBean("myAdd")); // @Bean(name = "myAdd")
        System.out.println(context.getBean("info"));
        System.out.println(context.getBean(Information.class)); // Infomation은 하나라서 하나 불러와짐
        System.out.println(context.getBean("address2"));
        System.out.println(context.getBean(Address.class)); // @Primary 작성한게 불러와짐
        System.out.println(context.getBean("info2"));
    }
}
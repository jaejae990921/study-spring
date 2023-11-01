package com.example.jdbc.jdbcExample;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class UserCommandRun implements CommandLineRunner { // 앱 실행 시 바로 실행되게 하려면 CommandLineRunner 인터페이스를 구현하면 됨

    @Autowired
    private UserJdbcRepository user;

    @Override
    public void run(String... args) throws Exception {
        user.insert(new Users(1, "심", "서울특별시")); // 쿼리문 바로 작성
        user.insert(new Users(2, "조", "서울특별시"));
        user.insert(new Users(3, "마", "서울특별시"));

        user.deleteId(2);

        System.out.println(user.findId(3));
    }
}

/**
 * @Component에서 파생된 어노테이션
 * @Repository
 * - 데이터 계층 컴포넌트
 * - 데이터베이스 연산에서 발생할 수 있는 예외를
 *   Spring의 'DataAccessException'으로 변하는 기능이 포함됨
 *
 * @Service
 * - 서비스 계층 컴포넌트
 * - 비즈니스 로직을 담당하는 클래스에서 사용
 *
 * @Controller
 * - 주로 어플리케이션에서 MVC패턴의 컨트롤러 역할을 담당
 * - @Controller를 사용한 클래스는 클라이언트의 요청을 받아 처리하고 응답
 *   (@RestController와 유사하지만 이거는 Restfull 웹 서비스에서 사용함)
 *
 *  ============================================================
 *
 * @AutoWired
 * 1. 필드 주입 : 필드에 직접 사용하면 Spring 컨테이너가
 *    자동으로 해당 타입의 Bean을 찾아 자동으로 필드에 주입
 * 장점 : 코드의 간결화
 * 단점 : 의존성을 변경하거나 테스트에 어려움이 생길 수 있다.
 * 
 * 2. 생성자 주입 : 생성자에 주입하면 Spring이 생성자의 파라미터 타입에 맞는 Bean을 찾아 주입
 * - 불변셩(=객체의 상태가 생성된 후 변경되지 않음)을 보장, 필요한 의존성이 명확하게 표시
 * 
 * 3. 메서드 주입 : setter 메서드나 임의의 메서드에 사용하면 해당 메서드의 파라미터 타입에 맞는 Bean을 찾아 주입
 * 
 * @AutoWired VS new
 * 공통점 : 객체를 생성하고 참조하는데 사용
 * 차이점
 * - @AutoWired: Spring의 IoC 컨테이너를 통해 의존성 주입을 위해 사용,
 *               어노테이션이 붙는 필드나 생성자는 스프링이 자동으로 해당 타입의 빈을 찾아 주입
 * - new : 개발자가 명시적으로 객체를 생성하고 주입.
 *
 *
 *
 *
 *
 *
 */
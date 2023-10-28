package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// 해당 클래스가 Controller 클래스라는 것을 Spring Container에게 알려줌
@Controller
public class HelloController {

    class Hello {
        private int age;

        public Hello(int age) {
            this.age = age;
        }

        public int getAge() {
            return age;
        }
    }


    // URL을 매핑시켜주는 것으로 get method로 해당 경로로 들어올 시 getHi라는 함수를 실행
    @GetMapping("/hi")
    public String getHi(Model model) {
        // Model model: 컨트롤러 클래스안의 메서드가 파라미터로 받을 수 있는 객체
        model.addAttribute("msg", "hi~~~"); // th:text 예시
        model.addAttribute("Hello", "Spring World"); // th:text 예시

        model.addAttribute("uText", "<strong>Hello</strong>"); // th:utext 예시
        model.addAttribute("value", "이름을 입력하세요"); // th:value 예시
        model.addAttribute("with", "hello"); // th:with 예시
        model.addAttribute("link", "hi"); // th:href 예시
        model.addAttribute("img", "이미지경로"); // th:src 예시
        model.addAttribute("userRole", "admin"); // th:switch 예시
        model.addAttribute("isAdmin", false); // th:if, th:unless 예시

        List<String> names = Arrays.asList("kim", "lee", "hone", "park"); // th:each 예시
        model.addAttribute("names", names); // th:each 예시

        Hello hello = new Hello(25);
        model.addAttribute("classHello", hello);

        // addAttribute은 model에 존재하는 메서드
        return "hi"; // hi.html 열어줌 res.render 같은 느낌
    }
}

// ${..} : 변수 표현식 // ${msg}
// @{..} : URL 링크 표현식 // @{/hi}
// *{..} : 선택 변수 표현식 *{msg} 단, th:object와 같이 사용 해야 함
// 컨트롤러 클래스 에서 private String msg = "hi";
// model.addAttribute("Msg", new HelloController());
// 템플릿에서 <div th:object=${Msg}><h1 th:text=*{msg}></hi></div>
// private라서 변수를 생성 해서 보내줌. th:object는 Msg를 객체를 의미 하고, *{msg}는 내부에 "hi"를 의미한다
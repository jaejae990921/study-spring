package com.example.SpringEx.controller;

import dto.UserDTO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;
import vo.UserVO;

@Controller
// @RestController 작성하면 모든 return이 html이 아니라 값이 됨
public class MainController {
    @GetMapping("/")
    public String getMain() {
        return "request";
    }
    
    @GetMapping("/get/response1")
    // ?key=value
    // /get/response1?name=abc&변수=값&변수=값
    // 물음표 뒤에 name이랑 value에 "name" 이랑 똑같아야 함 -> 뒤에 String name은 달라도 됨
    // 기본값으로 required=true를 갖기 때문에 ?name= 을 필수로 보내줘야 함. 없으면 오류 뜸
    public String getResponse1(@RequestParam(value = "name") String name, Model model) {
        model.addAttribute("name", name);
        return "response";
    }

    @GetMapping("/get/response2")
    // /get/response2 뒤에 name이 없어도 오류가 나지 않음
    // 검색 검색어는 필수 + 해시태그, 상세설정 선택
    // ?search=가
    // ?search=가&hashtag=집
    public String getResponse2(@RequestParam(value = "name", required = false) String name, Model model) {
        model.addAttribute("name", name);
        return "response";
    }

    @GetMapping("/get/response3/{name}/{age}") // 변수의 순서나 갯수가 정확히 지정되어있음
    // @PathVariable : 경로에 들어간 변수를 가져옴
    // 변수 이름을 그대로 쓸거면 첫번째 처럼, 이름을 바꾸고 싶으면 두번째 처럼 사용하면 됨
    public String getResponse3(@PathVariable String name, @PathVariable("age") String abc, Model model) {
        model.addAttribute("name", name);
        model.addAttribute("age", abc);
        return "response";
    }

    @GetMapping({"/get/response4/{name}/{age}", "/get/response4/{name}"})
    // @PathVariable 도 @RequestParams와 동일하게 required의 기본값이 true이다.
    // 근데 required = false를 설정해도 오류가 발생하는데, 위에 GetMapping에 이미 {name}/{age}로 변수 2개를 받기 때문에
    // {age}가 빠진 {name}를 추가해서 2개의 주소로 받을 수 있게 설정해줘야 한다.
    public String getResponse4(@PathVariable String name, @PathVariable(required = false) String age, Model model) {
        model.addAttribute("name", name);
        model.addAttribute("age", age);
        return "response";
    }

    // 실습 1 //

    @GetMapping("/introduce/{name}")
    public String prac1(@PathVariable String name, Model model) {
        model.addAttribute("name", name);
        return "response";
    }

    @GetMapping("/introduce2")
    public String prac2(@RequestParam(value = "name") String name, @RequestParam(value = "age") String age, Model model) {
        model.addAttribute("name", name);
        model.addAttribute("age", age);
        return "response";
    }

    // ---------- //

    @PostMapping("/post/response1")
    // html에 input 없애면 오류 난다.
    public String postResponse1(@RequestParam String name, Model model) {
        // @RequestBody : 전달받은 body 데이터를 json 형태의 객체로 만들어준다.
         model.addAttribute("name", name);
        return "response";
    }

    @PostMapping("/post/response2")
    // html에 input 없애도 오류가 발생하지 않음 -> required = false 라서 괜찮음
    public String postResponse2(@RequestParam(required = false) String name, Model model) {
        model.addAttribute("name", name);
        return "response";
    }

    @PostMapping("/post/response3")
    @ResponseBody // return에 "response"가 html이 아니라 실제 값을 전달함
    // html에 input 없애도 오류가 발생하지 않음 -> required = false 라서 괜찮음
    // @ResponseBody : response 데이터를 전달한다. // res.send
    public String postResponse3(@RequestParam(required = false) String name, Model model) {
        model.addAttribute("name", name);
        return "response";
    }

    // 실습 2 & 9 //

    @GetMapping("/postPrac")
    public String postPrac1() {
        return "postPrac";
    }

//    @PostMapping("/postPrac")
//    public String postPrac2(@RequestParam("name") String name,
//                            @RequestParam("gender") String gender,
//                            @RequestParam("year") String year,
//                            @RequestParam("month") String month,
//                            @RequestParam("day") String day,
//                            @RequestParam("hobby") String hobby, Model model) {
//        model.addAttribute("name", name);
//        model.addAttribute("gender", gender);
//        model.addAttribute("year", year);
//        model.addAttribute("month", month);
//        model.addAttribute("day", day);
//        model.addAttribute("hobby", hobby);
//        return "postPrac";
//    }

    @GetMapping("/axiosPrac")
    @ResponseBody
    public String axiosPrac(@RequestParam("name") String name, Model model) {
        String msg = name + "님 회원가입 성공!!";
        return msg;
    }

    // ---------- //

    // ----- DTO ----- //

    @GetMapping("/dto/response1")
    @ResponseBody
    public String dtoResponse1(@ModelAttribute UserDTO userDTO) {
        // DTO 앞에 어노테이션을 붙이지 않아도 @ModelAttribute가 기본으로 작성됨
        // @ModelAttribute 를 붙이나 안붙이나 동일함 -> 그래도 붙이는게 국룰인듯
        // @ModelAttribute : html 폼 데이터를 컨트롤러로 전달할 때 객체에 매핑해주는 친구
        // 매핑 -> 같은 이름끼리 set 함수를 실행한다.
        // -> 프론트에서 {name, age} -> setName, setAge를 실행한다.
        String msg = userDTO.getName() + " " + userDTO.getAge();
        return msg;
    }

    @GetMapping("/dto/response11")
    @ResponseBody
    public String dtoResponse11(@RequestBody UserDTO userDTO) {
        // Get 방식으로 전달하고 @RequestBody로 받으면 오류 남
        // @RequestBody : 요청의 본문에 있는 데이터(body) 값을 가져옴
        String msg = userDTO.getName() + " " + userDTO.getAge();
        return msg;
    }
    // 일반 폼전송 - DTO
    // 1) 아무것도 적지 않고 DTO 로 받으면 -> O
    // 2) @ModelAttribute DTO 로 받으면 -> O
    // 3) @ResponseBody DTO 로 받으면 -> X (오류)

    // @RequestBody는 요청의 본문에 있는 데이터(body)를 받아서 객체에 매핑
    // 단, 전달받은 요청의 데이터 형태가 json 또는 xml일 때만 실행이 가능
    // 일반 폼 전송은 www-x-form-urlencoded 형태임

    // ---------- //

    // ----- VO ----- //

    @GetMapping("/vo/response1")
    @ResponseBody
    public String voResponse(@ModelAttribute UserVO userVO) {
        // @ModelAttribute를 이용하면 객체의 set 함수를 이용해 값을 넣어주므로
        // VO는 setter가 없기때문에 값이 null이 나오게 됨
        String msg = userVO.getName() + " " + userVO.getAge();
        return msg;
    }

    @PostMapping("/vo/response2")
    @ResponseBody
    public String voResponse2(UserVO userVO) {
        String msg = userVO.getName() + " " + userVO.getAge();
        return msg;
        // 이것도 null 나옴
    }

    @PostMapping("/vo/response3")
    @ResponseBody
    public String voResponse3(@RequestBody UserVO userVO) {
        String msg = userVO.getName() + " " + userVO.getAge();
        return msg;
        // @RequestBody는 요청의 본문에 있는 데이터(body)를 받아서 객체에 매핑
        // 단, 전달받은 요청의 데이터 형태가 json 또는 xml일 때만 실행이 가능
        // 일반 폼 전송은 www-x-form-urlencoded 형태임
        // 따라서 오류 발생
    }

    // ---------- //

    // axios - DTO //

    @GetMapping("/axios/response1")
    @ResponseBody
    public String axiosResponse1(@RequestParam String name, @RequestParam String age) {
        // axios get 전송일 때, @RequestParam으로 값을 전달 받을 수 있다.
        String msg = "이름 : " + name + ", 나이 : " + age;
        return msg; // 가능
    }

    @GetMapping("/axios/response2")
    @ResponseBody
    public String axiosResponse2(UserDTO userDTO) {
        // axios get 전송일 때, @ModelAttribute로 값을 전달 받을 수 있다. ( = set 함수가 있는 객체 )
        String msg = "이름 : " + userDTO.getName() + ", 나이 : " + userDTO.getAge();
        return msg; // 가능
    }
    
    // ModelAttribute 와 @RequestParam 의 특징
    // 일반폼전송 -> 파라미터 형태로 들어옴
    // json으로 값을 보내면 파라미터 x 데이터 o ( 요청 본문 데이터 )
    // axios는 데이터로 보내기 때문에 ModelAttribute와 @RequestParam가 못 받음
    @PostMapping("/axios/response3")
    @ResponseBody
    public String axiosResponse3(@RequestParam String name, @RequestParam String age) {
        // axios post는 @RequestParam으로 못 받는다. -> 오류 발생
        String msg = "이름 : " + name + ", 나이 : " + age;
        return msg; // 실패
    }

    @PostMapping("/axios/response4")
    @ResponseBody
    public String axiosResponse4(UserDTO userDTO) {
        String msg = "이름 : " + userDTO.getName() + ", 나이 : " + userDTO.getAge();
        return msg; // Null
    }

    @PostMapping("/axios/response5")
    @ResponseBody
    public String axiosResponse5(@RequestBody UserDTO userDTO) {
        String msg = "이름 : " + userDTO.getName() + ", 나이 : " + userDTO.getAge();
        return msg; // 가능
    }

    // axios - vo //

    @GetMapping("/axios/vo/response2")
    @ResponseBody
    public String axiosVoResponse2(UserVO userVO) {
        String msg = "이름 : " + userVO.getName() + ", 나이 : " + userVO.getAge();
        return msg; // null
    }

    @PostMapping("/axios/vo/response4")
    @ResponseBody
    public String axiosVoResponse4(UserVO userVO) {
        String msg = "이름 : " + userVO.getName() + ", 나이 : " + userVO.getAge();
        return msg; // null
    }

    @PostMapping("/axios/vo/response5")
    @ResponseBody
    public String axiosVoResponse5(@RequestBody UserVO userVO) {
        // ModelAttribute는 setter 함수를 실행해 값을 넣어주는 친구
        // RequestBody는 setter 함수가 아닌 각각의 필드에 직접적으로 값을 주입하면서 매핑
        String msg = "이름 : " + userVO.getName() + ", 나이 : " + userVO.getAge();
        return msg; // 가능
    }
}

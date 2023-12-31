package com.mybatis.kdt9.controller;

import com.mybatis.kdt9.domain.User;
import com.mybatis.kdt9.dto.UserDTO;
import com.mybatis.kdt9.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class UserController {
//    1) domain
//    2) dto
//    3) mapper
//    4) service
//    5) controller
//    UserService를 호출하고 그에 대한 결과를 받아서 template으로 전달

    @Autowired
    UserService userService;

    @GetMapping("/")
    public String getUser(Model model) {
        List<UserDTO> users = userService.getUserList();
        model.addAttribute("list", users);
        return "user";
    }

    // get 방식으로 /user?name이름&nickname=닉네임
    @GetMapping("/user")
    public String insertUser(@RequestParam String name, @RequestParam String nickname) {
        userService.insertUser(name, nickname);
        return "user";
    }

    @GetMapping("/search")
    @ResponseBody
    public String selectUser(@RequestParam String name){
        return userService.searchUser(name);
    }

    @GetMapping("/searchid")
    @ResponseBody
    public String searchid(@RequestParam int id){
        return userService.searchId(id);
    }

    @GetMapping("/insert")
    @ResponseBody
    public String insertUser2(@RequestParam String name, @RequestParam String nickname) {
        String newName = userService.insertUser2(name, nickname);
        return newName + "Success";
    }

    // 사용자 이름 조회 만들어야 함

    @GetMapping("/nickname")
    @ResponseBody
    public String findNameorNickname(@RequestParam String word) {
        // 검색어 word를 기준으로 이름이거나 닉네임인 유저가 몇 명인지 조회
        int cnt = userService.searchNameOrNickname(word);

        return cnt + "명 입니다.";
    }

    @GetMapping("/check")
    @ResponseBody
    public String checkName(@RequestParam String name) {
        boolean result = userService.checkUser(name);
        return result ? "있습니다" : "없습니다.";
    }
}
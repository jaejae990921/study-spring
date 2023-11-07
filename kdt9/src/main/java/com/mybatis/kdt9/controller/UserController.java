package com.mybatis.kdt9.controller;

import com.mybatis.kdt9.domain.User;
import com.mybatis.kdt9.dto.UserDTO;
import com.mybatis.kdt9.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
}
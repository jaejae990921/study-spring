package com.example.mybatis.mybatis.controller;

import com.example.mybatis.mybatis.domain.Users;
import com.example.mybatis.mybatis.dto.PracDTO;
import com.example.mybatis.mybatis.dto.UserDTO;
import com.example.mybatis.mybatis.service.MainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class MainController {
    @Autowired
    private MainService mainService;

    @GetMapping("/users")
    public String getUsers(Model model) {
        List<UserDTO> userList = mainService.getUserList();
        model.addAttribute("list", userList);
        return "user";
    }

    @GetMapping("/insert")
    public String getInsertUser(@RequestParam String name, @RequestParam String address, Model model) {
        Users user = new Users();
        user.setName(name);
        user.setAddress(address);

        mainService.addUser(user);

        model.addAttribute("list", null);
        return "user";
    }

    @GetMapping("/prac")
    public String getPrac() {
        return "prac";
    }

    @PostMapping("/signup")
    @ResponseBody
    public String postSignup(@RequestBody PracDTO pracDTO) {
        mainService.pracSignup(pracDTO);
        return "회원가입 성공";
    }

    @PostMapping("/signin")
    @ResponseBody
    public String postSignin(@RequestBody PracDTO pracDTO) {
        String result = mainService.pracSignin(pracDTO);
        return result;
    }

    @PostMapping("/up")
    @ResponseBody
    public String postUp(@RequestBody PracDTO pracDTO) {
        mainService.pracUp(pracDTO);
        return "수정 완료";
    }

    @GetMapping("/del")
    @ResponseBody
    public String postDel(@RequestParam String id) {
        mainService.pracDel(id);
        return "삭제 완료";
    }
}

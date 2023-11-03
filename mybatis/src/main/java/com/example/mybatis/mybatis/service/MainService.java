package com.example.mybatis.mybatis.service;

import com.example.mybatis.mybatis.domain.Prac;
import com.example.mybatis.mybatis.domain.Users;
import com.example.mybatis.mybatis.dto.PracDTO;
import com.example.mybatis.mybatis.dto.UserDTO;
import com.example.mybatis.mybatis.mapper.MainMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.PersonRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class MainService {
    // XML 주입 - SQL쿼리와 Java 객체간의 매핑 정의
    @Autowired
    private MainMapper mainMapper;

    private PersonRepository personRepository; // JPA로 변경

    // 실제 데이터베이스에서 가져오는 Users 배열
    public List<UserDTO> getUserList() {
        List<Users> result = mainMapper.findAll();
        List<UserDTO> users = new ArrayList<>();

        for (int i = 0; i < result.size(); i++) {
            UserDTO user = new UserDTO();

            user.setId(result.get(i).getId());
            user.setName(result.get(i).getName());
            user.setAddress(result.get(i).getAddress());

            users.add(user);
        }

        return users;
    }

    public void addUser(Users user) {
        mainMapper.insertUser(user);
    }

    public void pracSignup(PracDTO pracDTO) {
        Prac prac = new Prac();

        prac.setId(pracDTO.getId());
        prac.setPw(pracDTO.getPw());
        prac.setNick((pracDTO.getNick()));

        mainMapper.pracSignup(prac);
    }

    public String pracSignin(PracDTO pracDTO) {
        PracDTO result = mainMapper.pracSignin(pracDTO);
        return result != null ? result.getNick() + "님 로그인 성공" : "로그인 실패";
    }

    public void pracUp(PracDTO pracDTO) {
        mainMapper.pracUp(pracDTO);
    }

    public void pracDel( String id) {
        mainMapper.pracDel(id);
    }
}

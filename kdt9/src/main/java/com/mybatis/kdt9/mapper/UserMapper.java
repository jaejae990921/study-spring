package com.mybatis.kdt9.mapper;

import com.mybatis.kdt9.domain.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface UserMapper {
    // xml 파일 참고
    List<User> retrieveAll(); // xml 파일에 retriveAll 를 실행

    // xml 파일을 참고하지 않고 SQL을 직접 작성(interface에서)
    @Insert("INSERT INTO user (name, nickname) VALUES (#{name}, #{nickname})")
    void insertUser(User user);
    // void insertUser(String name, String nickname) 으로 작성해도 됨
    // 위 Insert에 #{name}, #{nickname}은 어떻게 작성하든 알아서 값 찾아서 넣어줌
}

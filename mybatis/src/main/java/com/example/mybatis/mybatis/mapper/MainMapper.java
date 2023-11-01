package com.example.mybatis.mybatis.mapper;

import com.example.mybatis.mybatis.domain.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MainMapper {
    // mapper.xml 참고 하기
    List<User> retrieveAll(); // xml의 id와 같은 이름
    
    // mapper.xml 참고 안하기
    @Insert("INSERT INTO user (name, address) VALUES (#{name}, #{address})")
    void insertUser(User user);
}

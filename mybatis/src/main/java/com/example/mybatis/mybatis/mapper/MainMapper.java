package com.example.mybatis.mybatis.mapper;

import com.example.mybatis.mybatis.domain.Prac;
import com.example.mybatis.mybatis.domain.Users;
import com.example.mybatis.mybatis.dto.PracDTO;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface MainMapper {
    // mapper.xml 참고 하기
    List<Users> findAll(); // xml의 id와 같은 이름
    
    // mapper.xml 참고 안하기
    @Insert("INSERT INTO users (name, address) VALUES (#{name}, #{address})")
    void insertUser(Users user);

    @Insert("INSERT INTO prac VALUES (#{id}, #{pw}, #{nick})")
    void pracSignup(Prac prac);

    @Select("SELECT * FROM prac WHERE id = #{id} AND pw = #{pw}")
    PracDTO pracSignin(PracDTO pracDTO);

    @Delete("DELETE FROM prac WHERE id = #{id}")
    void pracDel(@Param("id") String id);

    @Update("UPDATE prac SET nick = #{nick} WHERE id = #{id}")
    void pracUp(PracDTO pracDTO);
}

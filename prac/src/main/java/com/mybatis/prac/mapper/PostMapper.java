package com.mybatis.prac.mapper;

import com.mybatis.prac.domain.Post;
import com.mybatis.prac.dto.PostDTO;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface PostMapper {
    List<Post> retrieveAll();

    @Insert("INSERT INTO post (title, content, writer) VALUES (#{title}, #{content}, #{writer})")
    void insertPost(Post post);

    @Update("UPDATE post SET title = #{title}, content = #{content} WHERE id = #{id}")
    void updatePost(Post post);

    @Delete("DELETE FROM post WHERE id = #{id}")
    void deletePost(Post post);
}

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

    void insertPost(Post post);

    void updatePost(Post post);

    void deletePost(int id);

    List<Post> searchPost(String word);
}

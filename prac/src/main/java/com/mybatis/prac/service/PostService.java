package com.mybatis.prac.service;

import com.mybatis.prac.domain.Post;
import com.mybatis.prac.dto.PostDTO;
import com.mybatis.prac.mapper.PostMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PostService {
    @Autowired
    PostMapper postMapper;

    public List<PostDTO> getPostList() {
        List<Post> result = postMapper.retrieveAll();
        List<PostDTO> posts = new ArrayList<>();

        for (Post post : result) {
            PostDTO postDTO = PostDTO.builder()
                    .id(post.getId())
                    .title(post.getTitle())
                    .content(post.getContent())
                    .writer(post.getWriter())
                    .registered(post.getRegistered())
                    .no(post.getWriter() + post.getId())
                    .build();

            posts.add(postDTO);
        }

        return posts;
    }

    public void insertPost(PostDTO postDTO) {
        Post post = new Post();

        post.setTitle(postDTO.getTitle());
        post.setContent(postDTO.getContent());
        post.setWriter(postDTO.getWriter());

        postMapper.insertPost(post);
    }


    public void updatePost(PostDTO postDTO) {
        Post post = new Post();

        post.setId(postDTO.getId());
        post.setTitle(postDTO.getTitle());
        post.setContent(postDTO.getContent());
        post.setWriter(postDTO.getWriter());

        postMapper.updatePost(post);
        // mapper 파일에서는 여러 개를 parameter로 받을 수 있는데
        // xml 파일은 하나밖에 못 받는다.
    }

    public void deletePost(int id) {
        postMapper.deletePost(id);
    }

    public List<PostDTO> searchPost(String word) {
        List<Post> result = postMapper.searchPost(word);
        List<PostDTO> posts = new ArrayList<>();

        for (Post post : result) {
            PostDTO postDTO = PostDTO.builder()
                    .id(post.getId())
                    .title(post.getTitle())
                    .content(post.getContent())
                    .writer(post.getWriter())
                    .registered(post.getRegistered())
                    .no(post.getWriter() + post.getId())
                    .build();

            posts.add(postDTO);
        }

        return posts;
    }

}

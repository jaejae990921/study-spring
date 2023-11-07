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

        for (int i = 0; i < result.size(); i++) {
            Post p =result.get(i);

            PostDTO post = PostDTO.builder()
                    .id(p.getId())
                    .title(p.getTitle())
                    .content(p.getContent())
                    .writer(p.getWriter())
                    .registered(p.getRegistered())
                    .build();

            posts.add(post);
        }

        return posts;
    }

    public boolean insertPost(PostDTO postDTO) {
        Post post = new Post();

        post.setTitle(postDTO.getTitle());
        post.setContent(postDTO.getContent());
        post.setWriter(postDTO.getWriter());

        postMapper.insertPost(post);

        return true;
    }


    public boolean updatePost(PostDTO postDTO) {
        Post post = new Post();

        post.setId(postDTO.getId());
        post.setTitle(postDTO.getTitle());
        post.setContent(postDTO.getContent());

        postMapper.updatePost(post);

        return true;
    }

    public boolean deletePost(PostDTO postDTO) {
        Post post = new Post();

        post.setId(postDTO.getId());

        postMapper.deletePost(post);

        return true;
    }
}

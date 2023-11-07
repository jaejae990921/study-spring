package com.mybatis.prac.controller;

import com.mybatis.prac.domain.Post;
import com.mybatis.prac.dto.PostDTO;
import com.mybatis.prac.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class PostController {
    @Autowired
    PostService postService;

    @GetMapping("/")
    @ResponseBody
    public List<PostDTO> getPost() {
        List<PostDTO> posts = postService.getPostList();
        return posts;
    }

    @PostMapping("/write")
    @ResponseBody
    public boolean wirtePost(@RequestBody PostDTO postDTO) {
        return postService.insertPost(postDTO);
    }

    @PatchMapping("/update")
    @ResponseBody
    public boolean updatePost(@RequestBody PostDTO postDTO) {
        return postService.updatePost(postDTO);
    }

    @DeleteMapping("/del")
    @ResponseBody
    public boolean deletePost(@RequestBody PostDTO postDTO) {
        return postService.deletePost(postDTO);
    }
}

package com.mybatis.prac.controller;

import com.mybatis.prac.domain.Post;
import com.mybatis.prac.dto.PostDTO;
import com.mybatis.prac.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@Controller
public class PostController {
    @Autowired
    PostService postService;

    @GetMapping("/board")
    public String getPost(Model model) {
        List<PostDTO> posts = postService.getPostList();
        model.addAttribute("list", posts);
        return "board";
    }

    @GetMapping("/board/search")
    @ResponseBody
    public HashMap<String, Object> searchBoard(@RequestParam String word, Model model) {
        List<PostDTO> posts = postService.searchPost(word);
        HashMap<String, Object> data = new HashMap<>();
        data.put("cnt", posts.size());
        data.put("list", posts);
        return data;
    }

    @PostMapping("/board")
    @ResponseBody
    public void writePost(@RequestBody PostDTO postDTO) {
        postService.insertPost(postDTO);
    }

    @PatchMapping("/board")
    @ResponseBody
    public void updatePost(@RequestBody PostDTO postDTO) {
        postService.updatePost(postDTO);
    }

    @DeleteMapping("/board")
    @ResponseBody
    public void deletePost(@RequestParam int id) {
        postService.deletePost(id);
    }
}

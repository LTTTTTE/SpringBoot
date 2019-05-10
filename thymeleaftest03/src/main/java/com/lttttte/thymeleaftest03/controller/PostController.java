package com.lttttte.thymeleaftest03.controller;

import com.lttttte.thymeleaftest03.domain.Post;
import com.lttttte.thymeleaftest03.repository.PostRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class PostController {

    private PostRepository postRepository;

    public PostController(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @GetMapping("/")
    public String index(Model model){

        List<Post> postList = postRepository.findAll();
        model.addAttribute("postList",postList);

        return "index";
    }
}

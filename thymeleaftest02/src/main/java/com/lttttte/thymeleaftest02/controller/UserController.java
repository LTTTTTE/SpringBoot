package com.lttttte.thymeleaftest02.controller;

import com.lttttte.thymeleaftest02.domain.User;
import com.lttttte.thymeleaftest02.repository.UserRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class UserController {

    private UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/signup")
    public String showSignUpForm(){
        return "add-user";
    }

    @PostMapping("/adduser")
    public String addUser(@Valid User user, BindingResult result, Model model){
        if(result.hasErrors())
            return "add-user";
        userRepository.save(user);
        model.addAttribute("user",userRepository.findAll());
        return "index";
    }
}

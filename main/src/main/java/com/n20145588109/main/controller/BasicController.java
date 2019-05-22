package com.n20145588109.main.controller;

import com.n20145588109.main.domain.Basic;
import com.n20145588109.main.repository.BasicRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BasicController {

    private BasicRepository basicRepository;

    public BasicController(BasicRepository basicRepository) {
        this.basicRepository = basicRepository;
    }

    @GetMapping("/")
    public String index(Model model){
        model.addAttribute("basicList",basicRepository.findAll());
        return "index";
    }

    @GetMapping("/add")
    public String add(Basic basic){
        return "add";
    }

}

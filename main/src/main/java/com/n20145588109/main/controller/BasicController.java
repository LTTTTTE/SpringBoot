package com.n20145588109.main.controller;

import com.n20145588109.main.domain.Basic;
import com.n20145588109.main.service.BasicService;
import com.n20145588109.main.service.ProfileService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.time.LocalDateTime;

@Controller
public class BasicController {

    private BasicService basicService;
    private ProfileService profileService;

    public BasicController(BasicService basicService, ProfileService profileService) {
        this.basicService = basicService;
        this.profileService = profileService;
    }

    @GetMapping("/")
    public String index(Model model){
        model.addAttribute("basicList",basicService.findAllBasicList());
        model.addAttribute("profileList",profileService.findAllProfileList());
        return "index";
    }

    @GetMapping("/basic/add")
    public String addBasic(Basic basic){
        return "addBasic";
    }

    @PostMapping("/basic/new")
    public String postBasic(Basic basic , Model model){
        basic.setCreatedDate(LocalDateTime.now());
        basic.setUpdatedDate(LocalDateTime.now());
        Basic savedBasic = basicService.saveBasic(basic);
        model.addAttribute("basic",basicService.findBasicByIdx(savedBasic.getIdx()));
        return "basic";
    }

    @GetMapping("/basic/{idx}")
    public String urlBasicIdx(@PathVariable Long idx, Model model){
        model.addAttribute("basic",basicService.findBasicByIdx(idx));
        return "basic";
    }

    @GetMapping("/basic/edit/{idx}")
    public String editBasic(@PathVariable Long idx , Model model){
        model.addAttribute("basic",basicService.findBasicByIdx(idx));
        return "updateBasic";
    }

    @PostMapping("/basic/update/{idx}")
    public String updateBasic(@PathVariable("idx") long idx, @Valid Basic basic,
                              BindingResult result, Model model) {
        if (result.hasErrors()) {
            basic.setIdx(idx);
            return "updateBasic";
        }

        basic.setCreatedDate(basicService.findBasicByIdx(idx).getCreatedDate());
        basic.setUpdatedDate(LocalDateTime.now());
        basicService.saveBasic(basic);
        model.addAttribute("basicList",basicService.findAllBasicList());
        model.addAttribute("profileList",profileService.findAllProfileList());
        return "index";
    }

    @GetMapping("/basic/remove/{idx}")
    public String deleteBasic(@PathVariable("idx") long idx, Model model){
        basicService.deleteBasicByIdx(idx);
        model.addAttribute("basicList",basicService.findAllBasicList());
        model.addAttribute("profileList",profileService.findAllProfileList());
        return "index";
    }


}

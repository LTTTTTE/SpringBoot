package com.n20145588109.main.controller;

import com.n20145588109.main.domain.Profile;
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
public class ProfileController {

    private ProfileService profileService;
    private BasicService basicService;

    public ProfileController(ProfileService profileService, BasicService basicService) {
        this.profileService = profileService;
        this.basicService = basicService;
    }

    @GetMapping("/profile/add")
    public String addProfile(Profile profile){
        return "addProfile";
    }

    @PostMapping("/profile/new")
    public String postProfile(Model model , Profile profile){

        profile.setCreatedDate(LocalDateTime.now());
        profile.setUpdatedDate(LocalDateTime.now());
        Profile saveProfile = profileService.saveProfile(profile);
        model.addAttribute("profile",saveProfile);
        return "profile";
    }

    @GetMapping("/profile/{idx}")
    public String urlProfileIdx(@PathVariable Long idx, Model model){
        model.addAttribute("profile",profileService.findProfileById(idx));
        return "profile";
    }

    @GetMapping("/profile/edit/{idx}")
    public String editProfile(@PathVariable Long idx , Model model) {
        model.addAttribute("profile", profileService.findProfileById(idx));
        return "updateProfile";
    }

    @PostMapping("/profile/update/{idx}")
    public String updateProfile(@PathVariable("idx") long idx, @Valid Profile profile,
                              BindingResult result, Model model) {
        if (result.hasErrors()) {
            profile.setIdx(idx);
            return "updateProfile";
        }
        profile.setCreatedDate(profileService.findProfileById(idx).getCreatedDate());
        profile.setUpdatedDate(LocalDateTime.now());
        profileService.saveProfile(profile);
        model.addAttribute("basicList",basicService.findAllBasicList());
        model.addAttribute("profileList",profileService.findAllProfileList());
        return "index";
    }

    @GetMapping("/profile/remove/{idx}")
    public String deleteProfile(@PathVariable("idx") long idx, Model model){
        profileService.deleteProfileByIdx(idx);
        model.addAttribute("basicList",basicService.findAllBasicList());
        model.addAttribute("profileList",profileService.findAllProfileList());
        return "index";
    }
}

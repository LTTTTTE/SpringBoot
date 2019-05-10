package com.lttttte.thymeleaftest04.controller;

import com.lttttte.thymeleaftest04.domain.Weather;
import com.lttttte.thymeleaftest04.repository.WeatherRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Collection;


@Controller
public class WeatherController {

    private WeatherRepository weatherRepository;

    public WeatherController(WeatherRepository weatherRepository) {
        this.weatherRepository = weatherRepository;
    }

    @GetMapping("/")
    public String showIndex(Model model){

        Collection<Weather> weatherList = weatherRepository.findAll();
        model.addAttribute("weatherList",weatherList);

        return "index";
    }
}

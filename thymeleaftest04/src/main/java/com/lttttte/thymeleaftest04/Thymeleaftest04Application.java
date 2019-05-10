package com.lttttte.thymeleaftest04;

import com.lttttte.thymeleaftest04.domain.Weather;
import com.lttttte.thymeleaftest04.domain.WeatherType;
import com.lttttte.thymeleaftest04.repository.WeatherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDateTime;
import java.util.Random;
import java.util.stream.IntStream;

@SpringBootApplication
public class Thymeleaftest04Application {

    public static void main(String[] args) {
        SpringApplication.run(Thymeleaftest04Application.class, args);
    }

    @Bean
    public CommandLineRunner runner(WeatherRepository weatherRepository){
        return (args)->{
            IntStream.rangeClosed(1,30).forEach(iterator->{
                weatherRepository.save(Weather.builder()
                        .weatherType(WeatherType.sunny)
                        .temperature(new Random().nextInt(30))
                        .dust(new Random().nextInt(200))
                        .createdDate(LocalDateTime.now())
                        .updatedDate(LocalDateTime.now())
                        .build());
            });
        };
    }
}

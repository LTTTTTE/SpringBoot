package com.n20145588109.main;

import com.n20145588109.main.domain.Basic;
import com.n20145588109.main.domain.Profile;
import com.n20145588109.main.repository.BasicRepository;
import com.n20145588109.main.repository.ProfileRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDateTime;
import java.util.concurrent.ThreadLocalRandom;

@SpringBootApplication
public class MainApplication {

    public static void main(String[] args) {
        SpringApplication.run(MainApplication.class, args);
    }

    @Bean
    public CommandLineRunner runner(BasicRepository basicRepository , ProfileRepository profileRepository){
        return args -> {
            profileRepository.save(Profile.builder()
                    .network("Github")
                    .userName("@LTTTTTE")
                    .url("https://www.github.com/@LTTTTTE")
                    .createdDate(LocalDateTime.now())
                    .updatedDate(LocalDateTime.now())
                    .build());
            profileRepository.save(Profile.builder()
                    .network("Naver")
                    .userName("@LTTTTTE")
                    .url("https://www.naver.com/@LTTTTTE")
                    .createdDate(LocalDateTime.now())
                    .updatedDate(LocalDateTime.now())
                    .build());
            profileRepository.save(Profile.builder()
                    .network("KSU")
                    .userName("@LTTTTTE")
                    .url("https://ks.ac.kr/@LTTTTTE")
                    .createdDate(LocalDateTime.now())
                    .updatedDate(LocalDateTime.now())
                    .build());

            ThreadLocalRandom.current().ints(50, 100).boxed().limit(20).forEach(x -> {
                basicRepository.save(Basic.builder()
                        .name("김씨" + x)
                        .label("몰라")
                        .email(x * x + "@gmail.com")
                        .phone((x * 3) + "-" + (x * 48) + "-" + (x * 99))
                        .createdDate(LocalDateTime.now())
                        .updatedDate(LocalDateTime.now())
                        .build());
            });
        };
    }

}

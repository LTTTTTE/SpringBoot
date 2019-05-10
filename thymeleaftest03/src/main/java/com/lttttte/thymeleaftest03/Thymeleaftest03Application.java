package com.lttttte.thymeleaftest03;

import com.lttttte.thymeleaftest03.domain.Post;
import com.lttttte.thymeleaftest03.repository.PostRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDateTime;
import java.util.stream.IntStream;

@SpringBootApplication
public class Thymeleaftest03Application {

    public static void main(String[] args) {
        SpringApplication.run(Thymeleaftest03Application.class, args);
    }

    @Bean
    public CommandLineRunner runner(PostRepository postRepository){
        return (args)->{
          IntStream.rangeClosed(1,100).forEach(x->{
              postRepository.save(Post.builder()
                      .title("타이틀"+x)
                      .content("내요오옹"+x)
                      .createdDate(LocalDateTime.now())
                      .updatedDate(LocalDateTime.now())
                      .build());
          });
        };
    }

}

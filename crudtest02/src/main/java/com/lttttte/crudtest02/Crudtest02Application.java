package com.lttttte.crudtest02;

import com.lttttte.crudtest02.domain.Board;
import com.lttttte.crudtest02.repository.BoardRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDateTime;
import java.util.stream.IntStream;

@SpringBootApplication
public class Crudtest02Application {

    public static void main(String[] args) {
        SpringApplication.run(Crudtest02Application.class, args);
    }
    @Bean
    public CommandLineRunner commandLineRunner(BoardRepository boardRepository){
        return (args) -> {
            IntStream.rangeClosed(1,100).forEach(x->{
                boardRepository.save(Board.builder()
                        .title("제목"+x)
                        .content("내용"+x)
                        .createdDate(LocalDateTime.now())
                        .updatedDate(LocalDateTime.now())
                        .build());
            });
        };
    }
}

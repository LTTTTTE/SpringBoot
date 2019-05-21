package com.lttttte.crudtest;

import com.lttttte.crudtest.domain.Board;
import com.lttttte.crudtest.repository.BoardRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDateTime;
import java.util.stream.IntStream;

@SpringBootApplication
public class CrudtestApplication {

    public static void main(String[] args) {
        SpringApplication.run(CrudtestApplication.class, args);
    }

    @Bean
    public CommandLineRunner runner(BoardRepository boardRepository){
        return (args ->{
            IntStream.rangeClosed(1,50).forEach(x->{
                boardRepository.save(Board.builder()
                        .title("제목 "+x)
                        .content("내용 "+x)
                        .createdDate(LocalDateTime.now())
                        .updatedDate(LocalDateTime.now())
                        .build());
            });
        });
    }
}

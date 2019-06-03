package com.lttttte.dbtest02;

import com.lttttte.dbtest02.domain.Movie;
import com.lttttte.dbtest02.domain.Studio;
import com.lttttte.dbtest02.repository.MovieRepository;
import com.lttttte.dbtest02.repository.StudioRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDateTime;

@SpringBootApplication
public class Dbtest02Application {

    public static void main(String[] args) {
        SpringApplication.run(Dbtest02Application.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(MovieRepository movieRepository , StudioRepository studioRepository){
        return args -> {

            Movie movie = new Movie();
            Studio studio = new Studio();
            Studio studio2 = new Studio();

            studio.setName("마블");
            studio.setOwner("주용");
            studioRepository.save(studio);

            studio2.setName("폭스");
            studio2.setOwner("바보");
            studioRepository.save(studio2);

            movie.setTitle("어벤져스");
            movie.setYear(LocalDateTime.now());
            movie.setStudioName("마블일꺼야");
            movie.setStudio(studio);
            movie.getStudio().getMovie().add(movie);
            movieRepository.save(movie);

            movie.setStudio(studio2);
            movie.getStudio().getMovie().add(movie);
            movieRepository.save(movie);

        };
    }
}

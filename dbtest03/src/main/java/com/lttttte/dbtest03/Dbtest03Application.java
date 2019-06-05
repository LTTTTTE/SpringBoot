package com.lttttte.dbtest03;

import com.lttttte.dbtest03.domain.Car;
import com.lttttte.dbtest03.domain.ParkingLot;
import com.lttttte.dbtest03.repository.CarRepository;
import com.lttttte.dbtest03.repository.ParkingLotRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.stream.IntStream;

@SpringBootApplication
public class Dbtest03Application {

    public static void main(String[] args) {
        SpringApplication.run(Dbtest03Application.class, args);
    }


    @Bean
    public CommandLineRunner commandLineRunner(CarRepository carRepository, ParkingLotRepository parkingLotRepository) {
        return args -> {

            ParkingLot parkingLot = new ParkingLot();
            parkingLot.setName("비싼주차장");
            parkingLotRepository.save(parkingLot);

            IntStream.rangeClosed(1, 10).forEach(x->{
                carRepository.save(Car.builder()
                        .name("자동차" +x)
                        .parkingLot(parkingLot)
                        .build()
                );
            });
            ParkingLot parkingLot2 = parkingLotRepository.save(ParkingLot.builder()
                    .name("좋은주차장")
                    .build());

        };
    }
}
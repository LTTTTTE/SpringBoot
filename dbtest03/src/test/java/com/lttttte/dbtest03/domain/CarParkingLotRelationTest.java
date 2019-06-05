package com.lttttte.dbtest03.domain;

import com.lttttte.dbtest03.repository.CarRepository;
import com.lttttte.dbtest03.repository.ParkingLotRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
public class CarParkingLotRelationTest {

    @Autowired
    private CarRepository carRepository;

    @Autowired
    private ParkingLotRepository parkingLotRepository;

    @Before
    public void init(){

    }

    @Test
    public void parkingLotChangeTest(){
        Car car = carRepository.findById(5L).orElse(null);
        ParkingLot parkingLot = parkingLotRepository.findById(2L).orElse(null);

        Optional.ofNullable(car).ifPresent(car1->{
            car1.setParkingLot(parkingLot);
        });

        assertThat(carRepository.findById(5L).orElse(null).getParkingLot().getName()).isEqualTo("좋은주차장");

    }

    @Test
    public void showDBTest(){
        parkingLotRepository.findAll().forEach(x->{
            System.out.println(x.getName() +" 에는");
            x.getCarSet().forEach(y->{
                System.out.print(y.getName() + " , ");
            });
            System.out.println("가 잇고");
        });

        carRepository.findAll().forEach(x->{
            System.out.println(x.getName() + " , " + x.getParkingLot().getName());
        });

    }

}

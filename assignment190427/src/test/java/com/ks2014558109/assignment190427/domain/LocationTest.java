package com.ks2014558109.assignment190427.domain;

import com.ks2014558109.assignment190427.repository.LocationRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
public class LocationTest {

    @Autowired
    LocationRepository locationRepository;
    Location savedLocation;

    @Before
    public void locationWriteTest(){

        savedLocation = locationRepository.save(Location.builder()
                .address("부산광역시 OO 구 OO 번길 OOO")
                .postCode("12345")
                .build()
        );
    }
    @Test
    public void locationReadTest(){
        assertThat(savedLocation)
                .isEqualTo(locationRepository.findById(savedLocation.getIdx()).orElse(null));
    }
}

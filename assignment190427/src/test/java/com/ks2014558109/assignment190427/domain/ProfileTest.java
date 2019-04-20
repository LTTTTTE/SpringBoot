package com.ks2014558109.assignment190427.domain;

import com.ks2014558109.assignment190427.repository.ProfileRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
public class ProfileTest {

    @Autowired
    ProfileRepository profileRepository;
    Profile savedProfile;

    @Before
    public void profileWriteTest(){
        savedProfile = profileRepository.save(Profile.builder()
                .network("Twitter")
                .userName("홍길동")
                .url("http://www.twitter.com/홍길동")
                .build()
        );
    }

    @Test
    public void profileReadTest(){
        assertThat(savedProfile)
                .isEqualTo(profileRepository.findById(savedProfile.getIdx()).orElse(null));
    }
}

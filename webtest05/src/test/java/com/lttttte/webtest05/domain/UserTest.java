package com.lttttte.webtest05.domain;

import com.lttttte.webtest05.repository.UserRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
public class UserTest {

    @Autowired
    private UserRepository userRepository;
    private User savedUser;

    @Before
    public void init(){
        savedUser = userRepository.save(User.builder().name("이름").age(13).build());
    }

    @Test
    public void userFindByIdTest(){
        assertThat(savedUser).isEqualTo(userRepository.findById(savedUser.getIdx()).orElse(null));
    }

    @Test
    public void userFindByNameTest(){
        assertThat(savedUser).isEqualTo(userRepository.findAllByName("이름").findFirst().orElse(null));
    }

    @Test
    public void userUpdateNameTest(){

        userRepository.findById(savedUser.getIdx()).orElse(null).setName("이름이름");

        assertThat(userRepository.findById(savedUser.getIdx()).orElse(null).getName())
                .isEqualTo("이름이름");
               // .isEqualTo(userRepository.findAllByName("이름이름").findFirst().orElse(null));
    }

    @Test
    public void userDeleteTest(){
        userRepository.delete(userRepository.findById(savedUser.getIdx()).orElse(null));

        assertThat(userRepository.findAll().isEmpty());
    }
}

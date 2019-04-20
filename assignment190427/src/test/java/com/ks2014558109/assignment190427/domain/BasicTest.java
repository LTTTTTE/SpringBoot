package com.ks2014558109.assignment190427.domain;

import com.ks2014558109.assignment190427.repository.BasicRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
public class BasicTest {

    @Autowired
    private BasicRepository basicRepository;

    private Basic savedBasic;

    @Before
    public void basicWriteTest(){

        savedBasic = basicRepository.save(Basic.builder()
                        .name("홍길동")
                        .lable("웹 프로그래머")
                        .email("홍길동@메일주소.도메인")
                        .phone("000-1234-5678")
                .build()
        );

        basicRepository.save(Basic.builder()
                .name("홍길동")
                .lable("학생")
                .email("HongGilDong@gmail.com")
                .phone("999-9999-9999")
                .build()
        );
    }

    @Test
    public void basicReadTestWithIdx(){
        assertThat(savedBasic.getIdx())
                .isEqualTo(basicRepository.findById(savedBasic.getIdx())
                        .orElse(null).getIdx()
                );
    }

    @Test
    public void basicReadTestWithEmail(){
        assertThat(savedBasic)
                .isEqualTo(basicRepository.findBasicsByName("홍길동")
                        .distinct()
                        .filter(x->!x.getEmail().contains("gmail.com"))
                        .findAny()
                        .orElse(null)
                );
    }
}

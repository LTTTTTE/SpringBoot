package com.lttttte.webtest04.domain;

import com.lttttte.webtest04.repository.MyTableRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
public class MyTableTest {

    @Autowired
    private MyTableRepository myTableRepository;
    private MyTable savedMyTable;

    @Before
    public void init(){
        savedMyTable = myTableRepository.save(
                MyTable.builder()
                        .title("제목1")
                        .content("내용1")
                        .build());
    }

    @Test
    public void myTableReadTestWithIdx(){
        assertThat(savedMyTable)
                .isEqualTo(myTableRepository.findById(savedMyTable.getIdx()).orElse(null));
    }

    @Test
    public void myTableReadTestWithContent(){
        assertThat(myTableRepository.findMyTableByContent("내용1"))
                .isEqualTo(savedMyTable);
    }



}

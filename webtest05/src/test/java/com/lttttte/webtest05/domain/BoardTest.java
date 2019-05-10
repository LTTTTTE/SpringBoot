package com.lttttte.webtest05.domain;

import com.lttttte.webtest05.repository.BoardRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@RunWith(SpringRunner.class)
public class BoardTest {

    @Autowired
    private BoardRepository boardRepository;
    private Board savedBoard;


    @Before
    public void init(){
        savedBoard = boardRepository.save(Board.builder()
                .title("제목")
                .content("컨텐츠")
                .createdDate(LocalDateTime.now())
                .updatedDate(LocalDateTime.now())
                .build());
    }

    @Test
    public void boardReadTest(){
        assertThat(savedBoard).isEqualTo(boardRepository.findById(savedBoard.getIdx()).orElse(null));
    }
}

package com.lttttte.webtest03.domain;

import com.lttttte.webtest03.repository.BoardRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
public class BoardTest {

    @Autowired
    private BoardRepository boardRepository;
    private Board saveBoard;

    @Before
    public void init(){
        Board board = Board.builder().content("HI").build();
        saveBoard = boardRepository.save(board);
    }

    @Test
    public void testFindBoard(){
        Board findBoard = boardRepository.findById(saveBoard.getIdx()).orElse(null);
        assertThat(findBoard.getIdx()).isEqualTo(saveBoard.getIdx());
    }
}

package com.lttttte.webtest02.domain;

import com.lttttte.webtest02.repository.BoardRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class) //필요
@DataJpaTest
public class BoardTest {

    @Autowired
    private BoardRepository boardRepository;

    private Board saveBoard;

    @Before
    public void init(){
        Board board = Board.builder().content("내용1").build();//객체화
        saveBoard = boardRepository.save(board);
    }

    //테스트코드 :
    //디비에 값이 저장됬는지 여부를
    //방금 저장한 데이터의 id 값과
    //디비전체 데이터의 아이디들중 하나와 비교해서 있는지 여부 확인.
    @Test
    public void testFindBoard(){
        Board findBoard = boardRepository
                .findById(saveBoard.getIdx())
                .orElse(null);

        //id값 같은지여부
        assertThat(findBoard.getIdx()).isEqualTo(saveBoard.getIdx());

    }
}
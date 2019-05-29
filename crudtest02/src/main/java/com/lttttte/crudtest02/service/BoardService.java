package com.lttttte.crudtest02.service;

import com.lttttte.crudtest02.domain.Board;
import com.lttttte.crudtest02.repository.BoardRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoardService {

    private BoardRepository boardRepository;

    public BoardService(BoardRepository boardRepository) {
        this.boardRepository = boardRepository;
    }

    public List<Board> findAllBoard(){
        return boardRepository.findAll();
    }

    public Board findBoardByIdx(Long idx){
        return boardRepository.findById(idx).orElse(null);
    }

    public Board saveBoard(Board board){
        return boardRepository.save(board);
    }
}

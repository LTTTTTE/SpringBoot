package com.lttttte.crudtest.controller;

import com.lttttte.crudtest.domain.Board;
import com.lttttte.crudtest.repository.BoardRepository;
import com.lttttte.crudtest.service.BoardService;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.time.LocalDateTime;

@Controller
public class BoardController  {

    private BoardRepository boardRepository;
    private BoardService boardService;

    public BoardController(BoardRepository boardRepository, BoardService boardService) {
        this.boardRepository = boardRepository;
        this.boardService = boardService;
    }

    @GetMapping("/")
    public String index(@PageableDefault Pageable pageable, Model model){
        model.addAttribute("boardList",boardService.findBoardList(pageable));
        return "index";
    }

    @GetMapping("/new")
    public String newBoard(Board board){
        return "new";
    }

    @PostMapping("/add")
    public String addBoard(Board board, Model model){

        board.setCreatedDate(LocalDateTime.now());
        board.setUpdatedDate(LocalDateTime.now());
        Board savedBoard = boardRepository.save(board);
        model.addAttribute("board",boardService.findBoardByIdx(savedBoard.getIdx()));
        return "item";
    }

    @GetMapping("/{idx}")
    public String getIdxUrl(@PathVariable Long idx, Model model){
        model.addAttribute("board",boardService.findBoardByIdx(idx));
        return "item";
    }
}

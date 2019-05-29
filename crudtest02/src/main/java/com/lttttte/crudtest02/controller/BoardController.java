package com.lttttte.crudtest02.controller;

import com.lttttte.crudtest02.domain.Board;
import com.lttttte.crudtest02.service.BoardService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.time.LocalDateTime;

@Controller
public class BoardController {

    private BoardService boardService;

    public BoardController(BoardService boardService) {
        this.boardService = boardService;
    }

    @GetMapping("/")
    public String index(Model model){
        model.addAttribute("boardList",boardService.findAllBoard());
        return "index";
    }

    @GetMapping("/board/new")
    public String newBoard(Board board){
        return "addBoard";
    }

    @PostMapping("/board/add")
    public String addBoard(Model model , Board board){
        board.setCreatedDate(LocalDateTime.now());
        board.setUpdatedDate(LocalDateTime.now());
        Board newBoard = boardService.saveBoard(board);
        model.addAttribute("board",boardService.findBoardByIdx(newBoard.getIdx()));
        return "board";
    }

    @GetMapping("/board/{idx}")
    public String indexIdx(@PathVariable long idx , Model model){
        model.addAttribute("board",boardService.findBoardByIdx(idx));
        return "board";
    }
}

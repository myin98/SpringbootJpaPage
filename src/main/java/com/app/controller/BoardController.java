package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.app.model.BoardEntity;
import com.app.repository.BoardEntityRepository;
import com.app.repository.Boards;
import com.app.service.BoardService;

@Controller
public class BoardController {

	@Autowired
	private BoardService BS;
	
	@GetMapping("/boards")
	public String boards() {
		return "board";
	}
	
	@Autowired
	private BoardEntityRepository bER;
	
	
	@GetMapping("/list")
	public String boardAll(Model model){
		List<BoardEntity> board = BS.findBoards() ;
		model.addAttribute("boards", board);
		//return bER.getBorads();
		
		//return bER.findAll();
		return "board";
	}
	
	
}

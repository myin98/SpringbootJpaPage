package com.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.app.model.BoardEntity;
import com.app.repository.BoardEntityRepository;

@Service
public class BoardService {

	@Autowired
	private BoardEntityRepository bER;
	
	
	
	
	public List<BoardEntity> findBoards(){
		return bER.findAll();
	}
	
	
	
}

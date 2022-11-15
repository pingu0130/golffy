package com.ssafy.ssafit.model.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ssafy.ssafit.model.dto.BoardDto;

@Service
public interface BoardService {

	List<BoardDto> list();

	BoardDto search(int boardid);

	boolean create(BoardDto boarddto);
	
	boolean modify(BoardDto boarddto);
	
	int delete (int boardid);
}

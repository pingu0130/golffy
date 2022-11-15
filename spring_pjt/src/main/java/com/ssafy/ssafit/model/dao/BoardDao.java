package com.ssafy.ssafit.model.dao;

import java.util.List;


import com.ssafy.ssafit.model.dto.BoardDto;

public interface BoardDao {
	List<BoardDto> list();

	BoardDto search(int id);

	int create(BoardDto boarddto);
	
	int modify(BoardDto boarddto);
	
	int delete (int id);
	
}

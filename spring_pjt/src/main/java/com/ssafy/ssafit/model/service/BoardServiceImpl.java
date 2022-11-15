package com.ssafy.ssafit.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.ssafit.model.dao.BoardDao;
import com.ssafy.ssafit.model.dto.BoardDto;

@Service
public class BoardServiceImpl implements BoardService {

	@Autowired
	private BoardDao boarddao;
	
	@Override
	public List<BoardDto> list() {
		return boarddao.list();
	}

	@Override
	public BoardDto search(int id) {
		return boarddao.search(id);
	}

	@Override
	public boolean create(BoardDto boarddto) {
		return boarddao.create(boarddto) == 1;
	}

	@Override
	public boolean modify(BoardDto boarddto) {
		return boarddao.modify(boarddto) == 1;
	}
	
	@Override 
	public int delete (int id) {
		return boarddao.delete(id);
	}
}

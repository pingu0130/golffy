package com.ssafy.ssafit.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.ssafit.model.dto.BoardDto;
import com.ssafy.ssafit.model.service.BoardService;

import io.swagger.annotations.ApiOperation;


@CrossOrigin(origins = { "*" }, maxAge = 6000)
@RestController
@RequestMapping("/board")
public class BoardController {
	private static final Logger logger = LoggerFactory.getLogger(BoardController.class);
	private static final String SUCCESS = "success";
	private static final String FAIL = "fail";
	
	@Autowired
	BoardService boardService;
	
	@ApiOperation(value = "모든 글의 리스트", response = List.class)
	@GetMapping
	public ResponseEntity<List<BoardDto>> listBoard(){
		logger.debug("boardlist");
		return new ResponseEntity<List<BoardDto>>(boardService.list(), HttpStatus.OK);
	}
	
	@ApiOperation(value = "id에 해당하는 글의 정보를 반환한다.", response = BoardDto.class)
	@GetMapping("/{id}")
	public ResponseEntity<BoardDto> searchBoard(@PathVariable int id) {
		logger.debug("searchTitle - 호출");
		return new ResponseEntity<>(boardService.search(id), HttpStatus.OK);
	}

	@ApiOperation(value = "새로운 게시글 입력한다", response = String.class)
	@PostMapping
	public ResponseEntity<String> createBoard(@RequestBody BoardDto boarddto) {
		logger.debug("insertBoard - 호출");
		if (boardService.create(boarddto)) {
			return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
		}
		return new ResponseEntity<String>(FAIL, HttpStatus.NO_CONTENT);
	}

	@ApiOperation(value = "id에 해당하는 게시글 정보를 수정한다", response = String.class)
	@PutMapping("{id}")
	public ResponseEntity<String> modifyBoard(@RequestBody BoardDto boarddto) {
		logger.debug("modifyBoard - 호출");
		logger.debug("" + boarddto);
		if (boardService.modify(boarddto)) {
			return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
		}
		return new ResponseEntity<String>(FAIL, HttpStatus.NO_CONTENT);
	}
	
	@ApiOperation(value = "게시글을 삭제한다.", response = BoardDto.class)
	@PostMapping("/{id}")
	public ResponseEntity<Integer> deleteBoard(@PathVariable int id) {
		logger.debug("deleteBaord - 호출");
		return new ResponseEntity<>(boardService.delete(id), HttpStatus.OK);
	}
}

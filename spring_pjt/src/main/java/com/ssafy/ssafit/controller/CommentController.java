package com.ssafy.ssafit.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.ssafit.model.dto.CmtDto;
import com.ssafy.ssafit.model.service.CmtService;

import io.swagger.annotations.ApiOperation;

@CrossOrigin(origins = { "*" }, maxAge = 6000)
@RestController
@RequestMapping("/cmt")
public class CommentController {
		private static final Logger logger = LoggerFactory.getLogger(CommentController.class);
		private static final String SUCCESS = "success";
		private static final String FAIL = "fail";
		
		@Autowired
		CmtService cmtService;
		
		@ApiOperation(value = "새로운 댓글 입력", response = String.class)
		@PostMapping
		public ResponseEntity<String> createCmt(@RequestBody CmtDto cmtdto) {
			logger.debug("insertCmt - 호출");
			if (cmtService.create(cmtdto)) {
				return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
			}
			return new ResponseEntity<String>(FAIL, HttpStatus.NO_CONTENT);
		}
		
		@ApiOperation(value = "id에 해당하는 댓글 수정", response = String.class)
		@PutMapping("{cmt_id}")
		public ResponseEntity<String> modifyCmt(@RequestBody CmtDto cmtdto) {
			logger.debug("modifyCmt - 호출");
			logger.debug("" + cmtdto);
			if (cmtService.modify(cmtdto)) {
				return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
			}
			return new ResponseEntity<String>(FAIL, HttpStatus.NO_CONTENT);
		}
		
		@ApiOperation(value = "댓글을 삭제한다.", response = CmtDto.class)
		@PostMapping("/{cmt_id}")
		public ResponseEntity<Integer> deleteCmt(@PathVariable int cmt_id) {
			logger.debug("deleteCmt - 호출");
			return new ResponseEntity<>(cmtService.delete(cmt_id), HttpStatus.OK);
		}
		
}

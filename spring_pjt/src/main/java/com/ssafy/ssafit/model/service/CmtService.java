package com.ssafy.ssafit.model.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ssafy.ssafit.model.dto.CmtDto;

@Service
public interface CmtService {
	List<CmtDto> list();

	boolean create(CmtDto cmtdto);
	
	boolean modify(CmtDto cmtdto);
	
	int delete (int id);

}

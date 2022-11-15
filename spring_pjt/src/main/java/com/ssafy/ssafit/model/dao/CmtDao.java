package com.ssafy.ssafit.model.dao;

import java.util.List;

import com.ssafy.ssafit.model.dto.CmtDto;

public interface CmtDao {
	
	List<CmtDto> list();

	int create(CmtDto cmtdto);
	
	int modify(CmtDto cmtdto);
	
	int delete (int id);
	
}

package com.ssafy.ssafit.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.ssafit.model.dao.CmtDao;
import com.ssafy.ssafit.model.dto.CmtDto;

@Service
public class CmtServiceImpl implements CmtService{

	
	@Autowired
	private CmtDao cmtdao;
	
	@Override
	public List<CmtDto> list() {
		return cmtdao.list();
	}

	@Override
	public boolean create(CmtDto cmtdto) {
		return cmtdao.create(cmtdto)==1;
	}

	@Override
	public boolean modify(CmtDto cmtdto) {
		return cmtdao.modify(cmtdto)==1;
	}

	@Override
	public int delete(int id) {
		return cmtdao.delete(id);
	}

}

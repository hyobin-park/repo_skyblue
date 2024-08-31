package com.color.infra.code;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CodeService {
	
	@Autowired
	private CodeDao codeDao;

	public List<CodeDto> selectList() {
		return codeDao.selectList();
	}
}

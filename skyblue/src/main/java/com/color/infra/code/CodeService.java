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
	//Code - CodeGroup Relation 
	//데이터를 넘겨줄 필요가 없음
	public List<CodeDto> selectListCodeGroup() {
		return codeDao.selectListCodeGroup();
	}
	
//	public List<CodeDto> selectListCodeGroup() {
//		List<CodeDto> codeGroups = codeDao.selectListCodeGroup();
//		return codeGroups;
//	}
	
	//insert
	public int codeinsert(CodeDto codeDto) {
		return codeDao.codeinsert(codeDto);
	}
	
	//update
	public int codeUpdate(CodeDto codeDto) {
		return codeDao.codeUpdate(codeDto);
	}
	
	//selectOne
	public CodeDto selectOne(CodeDto codeDto) {
		return codeDao.selectOne(codeDto);
	}
	
	//uelete
	public int codeUelete(CodeDto codeDto) {
		return codeDao.codeUelete(codeDto);
	}
	
	//delete
	public int codeDelete(CodeDto codeDto) {
		return codeDao.codeDelete(codeDto);
	}
	
}

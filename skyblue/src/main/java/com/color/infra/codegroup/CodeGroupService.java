package com.color.infra.codegroup;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CodeGroupService {
	
	@Autowired
	private CodeGroupDao codeGroupDao;
	
//	public List<CodeGroupDto> selectList() {
//		List<CodeGroupDto> codeGroups = codeGroupDao.selectList();
//		return codeGroups;
//		}
	
// 	함수 안에 내용이 없을 경우 아래와 같이 줄여서 쓴다.
	public List<CodeGroupDto> selectList() {
		return codeGroupDao.selectList();
	}

	public int insert(CodeGroupDto codeGroupDto) {
		return codeGroupDao.insert(codeGroupDto);
	}
	
//	public int insert(CodeGroupDto codeGroupDto) {
//		int result = codeGroupDao.insert(codeGroupDto);
//		return result;
//	}
	
	public CodeGroupDto selectOne(CodeGroupDto codeGroupDto) {
		return codeGroupDao.selectOne(codeGroupDto);
	}
	
//	public CodeGroupDto selectOne(CodeGroupDto codeGroupDto) {
//		CodeGroupDto dto = codeGroupDao.selectOne(codeGroupDto);
//		return dto;
//	}
	
	public int update(CodeGroupDto codeGroupDto) {
		return codeGroupDao.update(codeGroupDto);
	}
	
//	public int update(CodeGroupDto codeGroupDto) {
//		int a = codeGroupDao.update(codeGroupDto);
//		return a;
//	}

	//uelete
	public int uelete(CodeGroupDto codeGroupDto) {
		return codeGroupDao.uelete(codeGroupDto);
	}
	
	//delete
	public int delete(CodeGroupDto codeGroupDto) {
		return codeGroupDao.delete(codeGroupDto);
	}
}

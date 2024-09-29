package com.color.infra.code;

import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
public interface CodeDao {
	
	public List<CodeDto> selectList(CodeVo codeVo);
	
	public List<CodeDto> selectListCodeGroup();
	
	//insert
	public int codeinsert(CodeDto codeDto);
	
	//update
	public int codeUpdate(CodeDto codeDto);
	
	//selectOne
	public CodeDto selectOne(CodeDto codeDto);
	
	//uelete
	public int codeUelete(CodeDto codeDto);
	
	//delete
	public int codeDelete(CodeDto codeDto);
	
	public List<CodeDto> selectListCachedCodeArrayList();
	
	//selectOneCount
	public int selectOneCount(CodeVo codeVo);
}

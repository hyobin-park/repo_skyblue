package com.color.infra.codegroup;

import java.util.List;
import org.springframework.stereotype.Repository;

@Repository
public interface CodeGroupDao {
	
	//selectList
	public List<CodeGroupDto> selectList(CodeGroupVo codeGroupVo);
	
	//insert 
	public int insert(CodeGroupDto codeGroupDto);

	//update - selectOne
	public CodeGroupDto selectOne(CodeGroupDto codeGroupDto);
	
	//update - update
	public int update(CodeGroupDto codeGroupDto);
	
	//uelete
	public int uelete(CodeGroupDto codeGroupDto);
	
	//delete
	public int delete(CodeGroupDto codeGroupDto);
	
}
package com.color.infra.code;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.annotation.PostConstruct;

@Service
public class CodeService {
	
	@Autowired
	private CodeDao codeDao;

	public List<CodeDto> selectList(CodeVo codeVo) {
		return codeDao.selectList(codeVo);
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
	
	//selectOneCount
	public int selectOneCount(CodeVo codeVo) {
		return codeDao.selectOneCount(codeVo);
	}
	
	@PostConstruct
	public void selectListCachedCodeArrayList() {
//		System.out.println("selectListCachedCodeArrayList 함수 실행");
		List<CodeDto> codeListFromDb = (ArrayList<CodeDto>) codeDao.selectListCachedCodeArrayList();
		CodeDto.cachedCodeArrayList.clear();
		CodeDto.cachedCodeArrayList.addAll(codeListFromDb);
		System.out.println("cachedCodeArrayList: " + CodeDto.cachedCodeArrayList.size() + "chached!!");
	}
	
	public static void clear() {
		CodeDto.cachedCodeArrayList.clear();
	}
	
	public static List<CodeDto> selectListCachedCode(String ifcgSeq) {
		List<CodeDto> rt = new ArrayList<CodeDto>();
		for(CodeDto codeRow : CodeDto.cachedCodeArrayList) {
			if (codeRow.getCodegroup_ifcgSeq().equals(ifcgSeq)) {
				rt.add(codeRow);
			} else {
				// by pass
			}
		}
		return rt;
	}
	
	public static String selectOneCachedCode(int code) {
		String rt = "";
		for(CodeDto codeRow : CodeDto.cachedCodeArrayList) {
				if (codeRow.getIfcdSeq().equals(Integer.toString(code))) {
					rt = codeRow.getIfcdName();
				} else {
					// by pass
				}
			}
			return rt;
		}
}
	
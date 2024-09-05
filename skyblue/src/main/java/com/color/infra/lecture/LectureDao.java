package com.color.infra.lecture;

import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
public interface LectureDao {

	public List<LectureDto> selectLec();
	
	public int insert(LectureDto lectureDto);
	
	public LectureDto selectOne(LectureDto lectureDto);
	
	public int update(LectureDto lectureDto);
}

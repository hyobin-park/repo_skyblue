package com.color.infra.lecture;

import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
public interface LectureDao {

	public List<LectureDto> selectLec();
	
	public int insert(LectureDto lectureDto);
}

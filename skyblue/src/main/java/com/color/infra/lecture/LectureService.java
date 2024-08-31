package com.color.infra.lecture;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LectureService {

	@Autowired
	private LectureDao lectureDao;
	
	public List<LectureDto> selectLec() {
		List<LectureDto> lectures = lectureDao.selectLec();
		return lectures;
	}
	
	public int insert(LectureDto lectureDto) {
		return lectureDao.insert(lectureDto);
	}
	
	
}

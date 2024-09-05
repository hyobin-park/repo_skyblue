package com.color.infra.pmembers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PmembersService {
	
	@Autowired
	private PmembersDao pmembersDao;
	
	public List<PmembersDto> selectMem() {
		return pmembersDao.selectMem();
	}

	public int insert(PmembersDto pmembersDto) {
		return pmembersDao.insert(pmembersDto);
	}

	public PmembersDto selectOne(PmembersDto pmembersDto) {
		return pmembersDao.selectOne(pmembersDto);
	}
	
	public int update(PmembersDto pmembersDto) {
		return pmembersDao.update(pmembersDto);
	}

}

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

}

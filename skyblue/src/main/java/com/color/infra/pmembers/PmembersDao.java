package com.color.infra.pmembers;

import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
public interface PmembersDao {

	public List<PmembersDto> selectMem();
	
}

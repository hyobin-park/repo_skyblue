package com.color.infra.rooms;

import java.util.List;
import org.springframework.stereotype.Repository;

@Repository
public interface RoomsDao {
	
	// roomSelectList
	public List<RoomsDto> roomSelectList(RoomsVo roomsVo);
	
	// roomSelectOne
	public RoomsDto roomSelectOne(RoomsDto roomsDto);
	
	// roomInsert
	public int roomInsert(RoomsDto roomsDto);

	// roomUpdate
	public int roomUpdate(RoomsDto roomsDto);
	
	// selectOneCount
	public int selectOneCount(RoomsVo roomsVo);
	
}

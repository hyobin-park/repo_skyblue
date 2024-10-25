package com.color.infra.rooms;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoomsService {
	
	@Autowired
	private RoomsDao roomsDao;
	
	// roomSelectList
	public List<RoomsDto> roomSelectList(RoomsVo roomsVo) {
		return roomsDao.roomSelectList(roomsVo);
	}
	
	// roomSelectOne
	public RoomsDto roomSelectOne(RoomsDto roomsDto) {
		return roomsDao.roomSelectOne(roomsDto);
	}
	
	// roomInsert
	public int roomInsert(RoomsDto roomsDto) {
		return roomsDao.roomInsert(roomsDto);
	}
	
	// roomUpdate
	public int roomUpdate(RoomsDto roomsDto) {
		return roomsDao.roomUpdate(roomsDto);
	}
	
	// selectOneCount
	public int selectOneCount(RoomsVo roomsVo) { 
    	return roomsDao.selectOneCount(roomsVo);
    }

}

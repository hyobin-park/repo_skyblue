package com.color.infra.rooms;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoomsService {
	
	@Autowired
	private RoomsDao roomsDao;
	
	// roomSelectOne
		public List<RoomsDto> roomSelectOne() {
			List<RoomsDto> rooms = roomsDao.roomSelectOne();
			return rooms;
		}

}

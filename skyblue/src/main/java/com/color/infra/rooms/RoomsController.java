package com.color.infra.rooms;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class RoomsController {
	
	@Autowired
	RoomsService roomsService;
	
	@RequestMapping(value="/v1/infra/rooms/roomsXdmList")
	public String roomsXdmList() {
		List<RoomsDto> rooms = roomsService.roomSelectOne();
		return "/xdm/v1/infra/rooms/roomsXdmList";
	}

}

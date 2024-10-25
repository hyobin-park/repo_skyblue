package com.color.infra.rooms;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.color.common.util.UtilDateTime;

@Controller
public class RoomsController {
	
	@Autowired
	RoomsService roomsService;
	
	@RequestMapping(value="/v1/infra/rooms/roomsXdmList")
	public String roomsXdmList(@ModelAttribute("vo") RoomsVo roomsVo, Model model) {
		
		roomsVo.setShDateStart(roomsVo.getShDateStart() == null || roomsVo.getShDateStart() == "" ? null : UtilDateTime.add00TimeString(roomsVo.getShDateStart()));
		roomsVo.setShDateEnd(roomsVo.getShDateEnd() == null || roomsVo.getShDateEnd() == "" ? null : UtilDateTime.add59TimeString(roomsVo.getShDateEnd()));
		
		//paging
		roomsVo.setParamsPaging(roomsService.selectOneCount(roomsVo));

		if (roomsVo.getTotalRows() > 0) {
			model.addAttribute("list", roomsService.roomSelectList(roomsVo));
		}
		
		return "/xdm/v1/infra/rooms/roomsXdmList";
	}
	
	@RequestMapping(value="/v1/infra/rooms/roomsXdmForm")
	public String roomsXdmForm() {
		return "/xdm/v1/infra/rooms/roomsXdmForm";
	}
	
	@RequestMapping(value="/v1/infra/rooms/roomsXdmInst")
	public String roomsXdmInst(RoomsDto roomsDto) {
		roomsService.roomInsert(roomsDto);
		return "redirect:/v1/infra/rooms/roomsXdmList";
	}
	
	@RequestMapping(value="/v1/infra/rooms/roomsXdmMForm")
	public String roomsXdmMForm(RoomsDto roomsDto, Model model) {
		model.addAttribute("item", roomsService.roomSelectOne(roomsDto));
		return "/xdm/v1/infra/rooms/roomsXdmMForm";
	}
	
	@RequestMapping(value="/v1/infra/rooms/roomsXdmUpdt")
	public String roomsXdmUpdt(RoomsDto roomsDto) {
		roomsService.roomUpdate(roomsDto);
		return "redirect:/v1/infra/rooms/roomsXdmList";
	}
}

package com.color.infra.hotel;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HotelController {

	@Autowired
	HotelService hotelService;
	
	@RequestMapping(value="/v1/infra/hotel/hotelXdmList")
	public String hotelXdmList() {
		List<HotelDto> hotels = hotelService.hotelList();
		return "/xdm/v1/infra/hotel/hotelXdmList";
	}
	
	@RequestMapping(value="/v1/infra/hotel/hotelXdmForm")
	public String hotelXdmForm() {
		return "/xdm/v1/infra/hotel/hotelXdmForm";
	}
	
	@RequestMapping(value="/v1/infra/hotel/hotelXdmInst")
	public String hotelXdmInst(HotelDto hotelDto) {
		hotelService.hotelInsert(hotelDto);
		return "redirect:/v1/infra/hotel/hotelXdmList";
	}
}

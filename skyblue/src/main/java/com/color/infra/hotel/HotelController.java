package com.color.infra.hotel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.color.common.util.UtilDateTime;

@Controller
public class HotelController {

	@Autowired
	HotelService hotelService;
	
	@RequestMapping(value="/v1/infra/hotel/hotelXdmList")
	public String hotelXdmList(@ModelAttribute("vo") HotelVo hotelVo, Model model) {
		
//		hotelVo.setShDateStart(hotelVo.getShDateStart() + " 00:00:00");
//		hotelVo.setShDateEnd(hotelVo.getShDateEnd() + " 23:59:59");
		
		hotelVo.setShDateStart(hotelVo.getShDateStart() == null || hotelVo.getShDateStart() == "" ? null : UtilDateTime.add00TimeString(hotelVo.getShDateStart()));
		hotelVo.setShDateEnd(hotelVo.getShDateEnd() == null || hotelVo.getShDateEnd() == "" ? null : UtilDateTime.add59TimeString(hotelVo.getShDateEnd()));
		
		//paging
		hotelVo.setParamsPaging(hotelService.selectOneCount(hotelVo));

		if (hotelVo.getTotalRows() > 0) {
			model.addAttribute("list", hotelService.hotelList(hotelVo));
		}
		
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
	
	@RequestMapping(value="/v1/infra/hotel/hotelXdmMFom")
	public String hotelXdmMFom(HotelDto hotelDto, Model model) {
		model.addAttribute("hotelItem", hotelService.selectOne(hotelDto));
		return "/xdm/v1/infra/hotel/hotelXdmMFom";
	}
	
	@RequestMapping(value="/v1/infra/hotel/hotelXdmUpdt")
	public String hotelXdmUpdt(HotelDto hotelDto) {
		hotelService.hotelUpdate(hotelDto);
		return "redirect:/v1/infra/hotel/hotelXdmList";
	}
	
	@RequestMapping(value="/v1/infra/hotel/hotelXdmUel")
	public String hotelXdmUel(HotelDto hotelDto) {
		hotelService.hotelUelete(hotelDto);
		return "redirect:/v1/infra/hotel/hotelXdmList";
	}
	
	@RequestMapping(value="/v1/infra/hotel/hotelXdmDel")
	public String hotelXdmDel(HotelDto hotelDto) {
		hotelService.hotelDelete(hotelDto);
		return "redirect:/v1/infra/hotel/hotelXdmList";
	}
	
}

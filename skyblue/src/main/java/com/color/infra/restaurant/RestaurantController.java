package com.color.infra.restaurant;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class RestaurantController {

	@Autowired
	RestaurantService restaurantService;
	
	@RequestMapping(value="/v1/infra/restaurant/restaurantXdmList")
	public String restaurantXdmList(Model model) {
		model.addAttribute("list", restaurantService.selectRes());
		
//		for(RestaurantDto restaurantDto : restaurants) {
//			System.out.print(restaurantDto.getSeq() + "|");
//			System.out.print(restaurantDto.getType() + "|");
//			System.out.print(restaurantDto.getName() + "|");
//			System.out.print(restaurantDto.getOpenTime() + "|");
//			System.out.print(restaurantDto.getCloseTime() + "|");
//			System.out.print(restaurantDto.getTel() + "|");
//			System.out.print(restaurantDto.getWebsite() + "|");
//			System.out.print(restaurantDto.getParking() + "|");
//			System.out.print(restaurantDto.getReservation() + "|");
//			System.out.print(restaurantDto.getIntroduction() + "|");
//			System.out.print(restaurantDto.getRegDate() + "|");
//			System.out.println(restaurantDto.getEditDate() + "|");
//		}
		return "/xdm/v1/infra/restaurant/restaurantXdmList";
	}
}

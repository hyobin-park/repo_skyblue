package com.color.infra.usrhotel;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UsrhotelController {

	@RequestMapping(value="/v1/infra/usrhotel/usrHotelXdmIndex")
	public String usrHotelXdmIndex() {
		return "/usr/v1/infra/usrhotel/usrHotelXdmIndex";
	}
	
	@RequestMapping(value="/v1/infra/usrhotel/usrHotelXdmSignup")
	public String usrHotelXdmSignup() {
		return "/usr/v1/infra/usrhotel/usrHotelXdmSignup";
	}
	
}

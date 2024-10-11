package com.color.infra.usrhotel;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.color.infra.customer.CustomerDto;
import com.color.infra.customer.CustomerService;

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
	
	@RequestMapping(value="/v1/infra/usrhotel/usrHotelXdmSignin")
	public String usrHotelXdmSignin(CustomerDto customerDto) {
		customerService.LoginselectOne(customerDto);
		return "/usr/v1/infra/usrhotel/usrHotelXdmSignin";
	}
	
	@ResponseBody
	@RequestMapping(value="/v1/infra/usrhotel/usrhotelLoginProc")
	public Map<String, Object> usrhotelLoginProc(CustomerDto customerDto) {
		Map<String, Object> returnMap = new HashMap<String, Object>();		// 결과를 담기 위한 앱 생성
		
		CustomerDto rtMember = customerService.LoginselectOne(customerDto);	// 사용자 정보 조회
		
		if(rtMember != null) {
			returnMap.put("rt", "success");		// 응답 성공 설정
		} else {
			returnMap.put("rt", "fail");		// 응답 실패 설정
		}
		return returnMap;
	}
	
	
}

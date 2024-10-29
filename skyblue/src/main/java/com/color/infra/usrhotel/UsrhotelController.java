package com.color.infra.usrhotel;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.color.common.constants.Constants;
import com.color.infra.customer.CustomerDto;
import com.color.infra.customer.CustomerService;
import com.color.infra.hotel.HotelService;
import com.color.infra.hotel.HotelVo;

import jakarta.servlet.http.HttpSession;

@Controller
public class UsrhotelController {
	
	@Autowired
	CustomerService customerService;
	
	@Autowired
	HotelService hotelService;
	
	@RequestMapping(value="/v1/infra/usrhotel/usrHotelIndex")
	public String usrHotelXdmIndex() {
		return "/usr/v1/infra/usrhotel/usrHotelIndex";
	}
	
	@RequestMapping(value="/v1/infra/usrhotel/usrHotelList")
	public String usrHotelXdmList(@ModelAttribute("vo") HotelVo hotelVo, Model model) {
		
		//paging
		hotelVo.setParamsPaging(hotelService.selectOneCount(hotelVo));

		if (hotelVo.getTotalRows() > 0) {
			model.addAttribute("list", hotelService.hotelList(hotelVo));
		}
		
		return "/usr/v1/infra/usrhotel/usrHotelList";
	}
	
	@RequestMapping(value="/v1/infra/usrhotel/usrHotelDeList")
	public String usrHotelXdmDeList() {
		return "/usr/v1/infra/usrhotel/usrHotelDeList";
	}
	
	@RequestMapping(value="/v1/infra/usrhotel/usrHotelInst")
	public String usrHotelXdmInst(CustomerDto customerDto) {
		customerService.customerIns(customerDto);
		
		customerDto.setPassword(encodeBcrypt(customerDto.getPassword(), 10));
		
		return "redirect:/usr/v1/infra/usrhotel/usrHotelSignin";
	}
	
	@RequestMapping(value="/v1/infra/usrhotel/usrHotelSignup")
	public String usrHotelXdmSignup(CustomerDto customerDto) {
		return "/usr/v1/infra/usrhotel/usrHotelSignup";
	}
	
	@RequestMapping(value="/v1/infra/usrhotel/usrHotelSignin")
	public String usrHotelXdmSignin() {
		return "/usr/v1/infra/usrhotel/usrHotelSignin";
	}
	
	@ResponseBody
	@RequestMapping(value="/v1/infra/usrhotel/usrHotelSigninProc")
	public Map<String, Object> customerLoginProc(CustomerDto customerDto, HttpSession httpSession) {
		Map<String, Object> returnMap = new HashMap<String, Object>();		// 결과를 담기 위한 앱 생성
		
		CustomerDto rtMember = customerService.LoginselectOne(customerDto);	// 사용자 정보 조회
		
		if(rtMember != null) {
			CustomerDto rtMember2 = customerService.selectOneId(customerDto);
			
			if(rtMember2 != null) {
				//세션값 저장
				httpSession.setMaxInactiveInterval(60 * Constants.SESSION_MINUTE_XDM); // 60second * 30 = 30minute
				httpSession.setAttribute("sessSeqXdm", rtMember2.getCustomerSeq());
				httpSession.setAttribute("sessIdXdm", rtMember2.getId());
				httpSession.setAttribute("sessNameXdm", rtMember2.getCustomerName());
				
				returnMap.put("rt", "success");		// 응답 성공 설정
				
				System.out.println("sessSeqXdm: " + httpSession.getAttribute("sessSeqXdm"));
				System.out.println("sessIdXdm: " + httpSession.getAttribute("sessIdXdm"));
				System.out.println("sessNameXdm: " + httpSession.getAttribute("sessNameXdm"));
			}
		} else {
			returnMap.put("rt", "fail");			// 응답 실패 설정
		}
		return returnMap;
	}
	
	@ResponseBody
	@RequestMapping(value = "/v1/infra/usrhotel/usrHotelLogoutProc")
	public Map<String, Object> usrHotelXdmLogoutProc(HttpSession httpSession) {
		System.out.println("로그아웃");
		Map<String, Object> returnMap = new HashMap<String, Object>();
		httpSession.invalidate();
		returnMap.put("rt", "success");
		return returnMap;
	}
	
	// 암호화
	public String encodeBcrypt(String planeText, int strength) {
		  return new BCryptPasswordEncoder(strength).encode(planeText);
	}
	
	public boolean matchesBcrypt(String planeText, String hashValue, int strength) {
	  BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder(strength);
	  return passwordEncoder.matches(planeText, hashValue);
	}	
	
}

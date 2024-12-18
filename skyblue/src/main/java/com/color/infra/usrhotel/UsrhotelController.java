package com.color.infra.usrhotel;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.color.common.constants.Constants;
import com.color.infra.customer.CustomerDto;
import com.color.infra.customer.CustomerService;
import com.color.infra.hotel.HotelDto;
import com.color.infra.hotel.HotelService;
import com.color.infra.hotel.HotelVo;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
public class UsrhotelController {
	
	@Autowired
	CustomerService customerService;
	
	@Autowired
	HotelService hotelService;
	
	// 암호화
	public String encodeBcrypt(String planeText, int strength) {
		return new BCryptPasswordEncoder(strength).encode(planeText);
	}
	
	public boolean matchesBcrypt(String planeText, String hashValue, int strength) {
	  BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder(strength);
	  return passwordEncoder.matches(planeText, hashValue);
	}	
	
	
	@RequestMapping(value="/v1/infra/usrhotel/usrHotelIndex")
	public String usrHotelXdmIndex() {
		return "usr/v1/infra/usrhotel/usrHotelIndex";
	}
	
	@RequestMapping(value="/v1/infra/usrhotel/usrHotelList")
	public String usrHotelXdmList(@ModelAttribute("vo") HotelVo hotelVo, Model model) {
		
		//paging
		hotelVo.setParamsPaging(hotelService.selectOneCount(hotelVo));

		if (hotelVo.getTotalRows() > 0) {
			model.addAttribute("list", hotelService.hotelList(hotelVo));
		}
		
		return "usr/v1/infra/usrhotel/usrHotelList";
	}
	
	@RequestMapping(value="/v1/infra/usrhotel/usrHotelDeList")
	public String usrHotelXdmDeList(HotelDto hotelDto, Model model) {
		
		model.addAttribute("roomItem", hotelService.selectOne(hotelDto));				// selectOne
		model.addAttribute("hotelDeList", hotelService.HotelDeList(hotelDto));			// hotel Detail List
		model.addAttribute("reviewList", hotelService.ReviewSelectList(hotelDto));		// review
		
		return "usr/v1/infra/usrhotel/usrHotelDeList";
	}
		
	@RequestMapping(value="/v1/infra/usrhotel/usrHotelInst")
	public String usrHotelXdmInst(CustomerDto customerDto) {
		
		// 암호화
		customerDto.setPassword(encodeBcrypt(customerDto.getPassword(), 10));
		
		customerService.customerIns(customerDto);

		return "redirect:/usr/v1/infra/usrhotel/usrHotelSignin";
	}
	
	@RequestMapping(value="/v1/infra/usrhotel/usrHotelSignup")
	public String usrHotelXdmSignup(CustomerDto customerDto) {
		return "usr/v1/infra/usrhotel/usrHotelSignup";
	}
	
	@RequestMapping(value="/v1/infra/usrhotel/usrHotelSignin")
	public String usrHotelXdmSignin() {
		return "usr/v1/infra/usrhotel/usrHotelSignin";
	}
	
	@ResponseBody
	@RequestMapping(value="/v1/infra/usrhotel/usrHotelSigninProc")
	public Map<String, Object> customerLoginProc(CustomerDto customerDto, HttpSession httpSession) {
		Map<String, Object> returnMap = new HashMap<String, Object>();		// 결과를 담기 위한 앱 생성
		
		CustomerDto rtMember = customerService.LoginselectOne(customerDto);	// 사용자 정보 조회
		
		if(rtMember != null) {
			CustomerDto rtMember2 = customerService.selectOneId(customerDto);
			
		 if(matchesBcrypt(customerDto.getPassword(), rtMember.getPassword(), 10)) {
				
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
		 } // matchesBcrypt end
		 
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
	
	// usrHotelDeList에서 booking, roomBooking insert
	@RequestMapping(value = "/v1/infra/usrhotel/bookingInsert")
	public String bookingInsert(HotelDto hotelDto, HttpSession httpSession, Model model) {
			
		// 세션에서 sessSeqXdm 값 가져오기
		String sessSeqXdm = (String) httpSession.getAttribute("sessSeqXdm");
			
		if (sessSeqXdm != null) {
			// Customer_seq로 사용되는 값 설정
			hotelDto.setCustomer_seq(sessSeqXdm);
			
			// totalPrice 값 설정 (자동으로 폼에서 전달된 값이 hotelDto로 바인딩됨)
			System.out.println("총 금액: " + hotelDto.getTotalPrice()); // 확인용 출력
			for(int i = 0; i< hotelDto.getRoom_Seqs().length; i++) {
				
				String roomSeq = hotelDto.getRoom_Seqs()[i];  // 각 roomSeq 값 가져오기
                System.out.println("Room Seq: " + roomSeq);  // 확인용 출력
                
				hotelService.bookingInsert(hotelDto);
			}
			// 실제 bookingInsert와 관련된 서비스 호출
			hotelService.roomBookingInsert(hotelDto);
				
			// BookingSeq 값을 usrHotelBooking로 리다이렉션 전달
			return "redirect:/v1/infra/usrhotel/usrHotelBooking?bookingSeq=" + hotelDto.getBookingSeq();
		} else {
			// 세션에 사용자 정보가 없으면 처리
			return "redirect:/v1/infra/usrhotel/usrHotelSignin"; // 로그인 페이지로 리디렉션
		}
//		return "/v1/infra/hotel/userHotelBooking";
	}
	
	// DetailReviewInsert
	@ResponseBody
	@RequestMapping(value = "/usr/v1/infra/usrhotel/usrHotelRvInst", method = RequestMethod.POST)
	public Map<String, Object> usrHotelRvInst(@RequestParam("hotelSeq") String hotelSeq, HotelDto hotelDto, HttpSession httpSession) {
		Map<String, Object> response = new HashMap<>();

		// 세션 값 가져오기
		String sessSeqXdm = (String) httpSession.getAttribute("sessSeqXdm");
		String sessNameXdm = (String) httpSession.getAttribute("sessNameXdm");
		    
		hotelDto.setCustomer_seq(sessSeqXdm);
		hotelDto.setHotel_seq(hotelSeq);
		hotelDto.setCustomerName(sessNameXdm);
		
//		System.out.println("hotelSeq : " + hotelDto.getHotel_seq());
//		System.out.println("hotelDto : " + hotelDto.toString());

		// 리뷰 삽입
		int result = hotelService.DetailReviewInsert(hotelDto);
		    
		if (result > 0) {
			response.put("rt", "success");
		    response.put("success", true);
		    response.put("customerName", hotelDto.getCustomerName());
		    response.put("reStars", hotelDto.getReStars());	
		    response.put("reTitle", hotelDto.getReTitle());
		    response.put("reDesc", hotelDto.getReDesc());
		} else {
		    response.put("rt", "fail");
		    response.put("message", "리뷰 실패");
		}

		return response;
		}
		
	// usrHotelBooking
	@RequestMapping(value="/v1/infra/usrhotel/usrHotelBooking")
	public String userHotelBooking(HotelDto hotelDto, @RequestParam("bookingSeq") String bookingSeq, Model model, HttpServletRequest request) {
		
		model.addAttribute("hotelItem", hotelService.bookingHotelSelectOne(hotelDto));
		model.addAttribute("bookingItem", hotelService.bookingSelectOne(hotelDto));
		model.addAttribute("bookingRoomList", hotelService.bookingRoomSelectList(hotelDto));
		
		return "usr/v1/infra/usrhotel/usrHotelBooking";
	}
	
	// bookingUpdt(결제수단, 결제일 업데이트)
	@RequestMapping(value="/v1/infra/usrhotel/bookingUpdt")
	public String bookingUpdt(HotelDto hotelDto) {
		hotelService.bookingUpdate(hotelDto);
		return "usr/v1/infra/usrhotel/usrHotelPaymentCom";
	}
	
	// 결제완료 후 이동할 페이지 띄우기
	@RequestMapping(value="/v1/infra/usrhotel/usrHotelPaymentCom")
	public String usrHotelPaymentCom() {
		return "usr/v1/infra/usrhotel/usrHotelPaymentCom";
	}
	
	// 마이페이지
	@RequestMapping(value="/v1/infra/usrhotel/usrHotelMyPage")
	public String usrHotelMyPage(@ModelAttribute("vo") HotelVo hotelVo, Model model, HttpSession httpSession) {
		// 세션에서 sessSeqXdm 값 가져오기
		String sessSeqXdm = (String) httpSession.getAttribute("sessSeqXdm");
		
		hotelVo.setCustomerSeq(sessSeqXdm);
		
		//paging
		hotelVo.setParamsPaging(hotelService.bkSelectOneCount(hotelVo));

		if (hotelVo.getTotalRows() > 0) {
			model.addAttribute("myBkList", hotelService.myPageBkSelectList(hotelVo));
		}
		
		return "usr/v1/infra/usrhotel/usrHotelMyPage";
	}
	
}

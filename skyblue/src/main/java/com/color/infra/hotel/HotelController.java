package com.color.infra.hotel;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.color.common.util.UtilDateTime;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

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
		
		return "xdm/v1/infra/hotel/hotelXdmList";
	}
	
	@RequestMapping(value="/v1/infra/hotel/hotelXdmForm")
	public String hotelXdmForm() {
		return "xdm/v1/infra/hotel/hotelXdmForm";
	}
	
	@RequestMapping(value="/v1/infra/hotel/hotelXdmInst")
	public String hotelXdmInst(HotelDto hotelDto) throws Exception {
//		System.out.println("insert 해유~");
		hotelService.hotelInsert(hotelDto, 0);
		return "redirect:/v1/infra/hotel/hotelXdmList";
	}
	
	@RequestMapping(value="/v1/infra/hotel/hotelXdmMFom")
	public String hotelXdmMFom(HotelDto hotelDto, Model model) {
		model.addAttribute("hotelItem", hotelService.selectOne(hotelDto));
		return "xdm/v1/infra/hotel/hotelXdmMFom";
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
	
    // ShopDetail에서 booking, B_bookingMenu insert
	@RequestMapping(value = "/v1/infra/hotel/bookingInsert")
	public String bookingInsert(HotelDto hotelDto,@RequestParam("room_Seqs") List<String> Room_Seqs, HttpSession httpSession) {
		
		// 세션에서 sessSeqXdm 값 가져오기
		String sessSeqXdm = (String) httpSession.getAttribute("sessSeqXdm");
		
		if (sessSeqXdm != null) {
			// Customer_seq로 사용되는 값 설정
			hotelDto.setCustomer_seq(sessSeqXdm);
			
			// menuSeqs 값을 hotelDto에 설정
			hotelDto.setRoom_Seqs(Room_Seqs);	// hotelDto에 Room_Seqs 필드 추가
			
			// totalPrice 값 설정 (자동으로 폼에서 전달된 값이 hotelDto로 바인딩됨)
			System.out.println("총 금액: " + hotelDto.getTotalPrice()); // 확인용 출력
			
			// 실제 shopBookingInsert와 관련된 서비스 호출
			hotelService.bookingInsert(hotelDto);
			hotelService.roomBookingInsert(hotelDto);
		} else {
			// 세션에 사용자 정보가 없으면 처리
			return "redirect:/v1/infra/usrhotel/usrHotelSignin"; // 로그인 페이지로 리디렉션
		}
		
		return "/v1/infra/hotel/userHotelBooking";
	}
	
	// ShopPayment
	@RequestMapping(value="/v1/infra/hotel/userHotelBooking")
	public String userHotelBooking(HttpServletRequest request) {
		return "/v1/infra/hotel/userHotelBooking";
	}
	
}

package com.color.infra.kakaopay;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order")
public class KakaoPayController {
	
	@Autowired
	KakaoPayService kakaoPayService;
	
	@Autowired
	SessionUtils sessionUtils;
	    
	@PostMapping("/pay/ready")
	public @ResponseBody ReadyResponseDto readyResponseDto(@RequestBody OrderCreateFormDto orderCreateFormDto) {

		 String name = orderCreateFormDto.getName();
		 int totalPrice = orderCreateFormDto.getTotalPrice();
		 
		 System.out.println("주문 상품 이름: " + name);
		 System.out.println("주문 금액: " + totalPrice);

		 // 카카오 결제 준비하기
		 ReadyResponseDto readyResponseDto = kakaoPayService.readyResponseDto(name, totalPrice);
		 // 세션에 결제 고유번호(tid) 저장
		 SessionUtils.addAttribute("tid", readyResponseDto.getTid());
		 System.out.println("결제 고유번호: " + readyResponseDto.getTid());
	
		 return readyResponseDto;
	 }

	 @GetMapping("/pay/completed")
	 public String payCompleted(@RequestParam("pg_token") String pgToken) {
	    
		 String tid = SessionUtils.getStringAttributeValue("tid");
		 
		 System.out.println("결제승인 요청을 인증하는 토큰: " + pgToken);
		 System.out.println("결제 고유번호: " + tid);
		 
//		 log.info("결제승인 요청을 인증하는 토큰: " + pgToken);
//		 log.info("결제 고유번호: " + tid);
	
		 // 카카오 결제 요청하기
		 ApproveResponseDto approveResponseDto = kakaoPayService.approveResponseDto(tid, pgToken);
		 
		 return "redirect:/order/completed";
	 }
	 

}

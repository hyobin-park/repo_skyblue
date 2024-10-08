package com.color.infra.customer;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.color.common.util.UtilDateTime;

import jakarta.servlet.http.HttpSession;

@Controller
public class CustomerController {
	
	@Autowired
	private CustomerService customerService;
	
	@RequestMapping(value="/v1/infra/customer/customerXdmList")
	public String customerXdmList(@ModelAttribute("vo") CustomerVo customerVo, Model model) {
		
//		customerVo.setShDateStart(customerVo.getShDateStart() + " 00:00:00");
//		customerVo.setShDateEnd(customerVo.getShDateEnd() + " 23:59:59");
		
		customerVo.setShDateStart(customerVo.getShDateStart() == null || customerVo.getShDateStart() == "" ? null : UtilDateTime.add00TimeString(customerVo.getShDateStart()));
		customerVo.setShDateEnd(customerVo.getShDateEnd() == null || customerVo.getShDateEnd() == "" ? null : UtilDateTime.add59TimeString(customerVo.getShDateEnd()));
		
		//paging
		customerVo.setParamsPaging(customerService.selectOneCount(customerVo));

		if (customerVo.getTotalRows() > 0) {
		model.addAttribute("customerList", customerService.customerList(customerVo));
		}
		
		return "/xdm/v1/infra/customer/customerXdmList";
	}
	
	@RequestMapping(value="/v1/infra/customer/customerXdmForm")
	public String customerXdmForm() {
		return "/xdm/v1/infra/customer/customerXdmForm";
	}
	
	@RequestMapping(value="/v1/infra/customer/customerXdmInst")
	public String customerXdmInst(CustomerDto customerDto) {
		customerService.customerIns(customerDto);
		return "redirect:/v1/infra/customer/customerXdmList";
	}
	
	@RequestMapping(value="/v1/infra/customer/customerXdmMFom")
	public String customerXdmMFom(CustomerDto customerDto, Model model) {
		model.addAttribute("customerItem", customerService.selectOne(customerDto));
		return "/xdm/v1/infra/customer/customerXdmMFom";
	}
	
	@RequestMapping(value="/v1/infra/customer/customerXdmUpdt")
	public String customerXdmUpdt(CustomerDto customerDto) {
		customerService.customerUpdt(customerDto);
		return "redirect:/v1/infra/customer/customerXdmList";
	}
	
	@RequestMapping(value="/v1/infra/customer/customerXdmUel")
	public String customerXdmUel(CustomerDto customerDto) {
		customerService.customerUel(customerDto);
		return "redirect:/v1/infra/customer/customerXdmList";
	}
	
	@RequestMapping(value="/v1/infra/customer/customerXdmDel")
	public String customerXdmDel(CustomerDto customerDto) {
		customerService.customerDel(customerDto);
		return "redirect:/v1/infra/customer/customerXdmList";
	}
	
	@RequestMapping(value="/v1/infra/customer/customerXdmMain")
	public String customerXdmMain() {
		return "/xdm/v1/infra/customer/customerXdmMain";
	}
	
	@RequestMapping(value="/v1/infra/customer/customerLogIn")
	public String customerLogIn() {
		return "/xdm/v1/infra/customer/customerLogIn";
	}
	
	@ResponseBody
	@RequestMapping(value="/v1/infra/customer/customerLoginProc")
	public Map<String, Object> customerLoginProc(CustomerDto customerDto, HttpSession httpSession) {
		Map<String, Object> returnMap = new HashMap<String, Object>();
		
		CustomerDto rtMember = customerService.LoginselectOne(customerDto);
		
		if(rtMember != null) {
			CustomerDto rtMember2 = customerService.selectOneId(customerDto);
			
			if(rtMember2 != null) {
				//세션값 저장
				httpSession.setMaxInactiveInterval(60 * Constants.SESSION_MINUTE_XDM); // 60second * 30 = 30minute
				httpSession.setAttribute("sessSeqXdm", rtMember2.getCustomerSeq());
				httpSession.setAttribute("sessIdXdm", rtMember2.getId());
				httpSession.setAttribute("sessNameXdm", rtMember2.getCustomerName());
				
				returnMap.put("rt", "success");
				
				System.out.println("sessSeqXdm: " + httpSession.getAttribute("sessSeqXdm"));
				System.out.println("sessIdXdm: " + httpSession.getAttribute("sessIdXdm"));
				System.out.println("sessNameXdm: " + httpSession.getAttribute("sessNameXdm"));
			}
		} else {
			returnMap.put("rt", "fail");
		}
		return returnMap;
	}
	
	@RequestMapping(value="/v1/infra/customer/customerSignUp")
	public String customerSignUp() {
		return "/xdm/v1/infra/customer/customerSignUp";
	}
	
	@ResponseBody
	@RequestMapping(value = "/v1/infra/customer/customerLogoutProc")
	public Map<String, Object> customerLogoutProc(HttpSession httpSession) {
		System.out.println("로그아웃");
		Map<String, Object> returnMap = new HashMap<String, Object>();
		httpSession.invalidate();
		returnMap.put("rt", "success");
		return returnMap;
	}
}
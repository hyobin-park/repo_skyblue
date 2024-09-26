package com.color.infra.customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.color.common.util.UtilDateTime;

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
	
	@RequestMapping(value="/v1/infra/customer/customerLogIn")
	public String customerLogin() {
		return "/xdm/v1/infra/customer/customerLogIn";
	}
	
	@RequestMapping(value="/v1/infra/customer/customerSignUp")
	public String customerSignUp() {
		return "/xdm/v1/infra/customer/customerSignUp";
	}

}

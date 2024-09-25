package com.color.infra.customer;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.color.infra.code.CodeService;

@Controller
public class CustomerController {
	
	@Autowired
	private CustomerService customerService;
	
	@RequestMapping(value="/v1/infra/customer/customerXdmList")
	public String customerXdmList(Model model, CustomerVo customerVo) {
		
		customerVo.setShDateStart(customerVo.getShDateStart() + " 00:00:00");
		customerVo.setShDateEnd(customerVo.getShDateEnd() + " 23:59:59");
		
		model.addAttribute("customerList", customerService.customerList(customerVo));
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

}

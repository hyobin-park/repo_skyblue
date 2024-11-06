package com.color.infra.customer;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/rest/customer")
public class CustomerRestController {
	
	@Autowired
	CustomerService customerService;

//	@RequestMapping(value = "", method = RequestMethod.GET)
	@GetMapping("")
	public List<CustomerDto> customerList(CustomerVo customerVo) throws Exception {
		List<CustomerDto> list = customerService.customerList(customerVo);
		System.out.println(list+"@@@@@@@@@@@@");
		return list;
	}
	
	@GetMapping("/{customerSeq}")
	public CustomerDto selectOne(CustomerDto customerDto) throws Exception {
		CustomerDto item = customerService.selectOne(customerDto);
		return item;
	}
}
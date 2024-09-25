package com.color.infra.customer;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {

	@Autowired
	private CustomerDao customerDao;
	
	public List<CustomerDto> customerList(CustomerVo customerVo) {
		return customerDao.customerList(customerVo);
	}
	
	public int customerIns(CustomerDto customerDto) {
		return customerDao.customerIns(customerDto);
	}
	
	public CustomerDto selectOne(CustomerDto customerDto) {
		return customerDao.selectOne(customerDto);
	}
	
	public int customerUpdt(CustomerDto customerDto) {
		return customerDao.customerUpdt(customerDto);
	}
	
	public int customerUel(CustomerDto customerDto) {
		return customerDao.customerUel(customerDto);
	}
	
	public int customerDel(CustomerDto customerDto) {
		return customerDao.customerDel(customerDto);
	}
	
}

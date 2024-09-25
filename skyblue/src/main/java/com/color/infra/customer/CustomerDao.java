package com.color.infra.customer;

import java.util.List;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerDao {
	
	//customerList
	public List<CustomerDto> customerList(CustomerVo customerVo);

	//insert
	public int customerIns(CustomerDto customerDto);
	
	//selectOne
	public CustomerDto selectOne(CustomerDto customerDto);
	
	//update
	public int customerUpdt(CustomerDto customerDto);
	
	//uelete
	public int customerUel(CustomerDto customerDto);
	
	//delete
	public int customerDel(CustomerDto customerDto);
}

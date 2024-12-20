package com.color.infra.customer;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class CustomerDto {

	private String customerSeq;
	private String customerName;
	private Integer gender;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date birthDate;
	private String email;
	private String phoneNumber;
	private String id;
	private String password;
	private String customerZipCode;
	private String customerAddress1;
	private String customerAddress2;
	private Integer registerAgreeContentNy;
	private Integer customer_delNy;
	private Integer customer_useNy;
	private String customerDesc;
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private Date customerRgDate;
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private Date customerEditDate;
	
	// ----- getter/setter -----
	public String getCustomerSeq() {
		return customerSeq;
	}
	public void setCustomerSeq(String customerSeq) {
		this.customerSeq = customerSeq;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public Integer getGender() {
		return gender;
	}
	public void setGender(Integer gender) {
		this.gender = gender;
	}
	public Date getBirthDate() {
		return birthDate;
	}
	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getCustomerZipCode() {
		return customerZipCode;
	}
	public void setCustomerZipCode(String customerZipCode) {
		this.customerZipCode = customerZipCode;
	}
	public String getCustomerAddress1() {
		return customerAddress1;
	}
	public void setCustomerAddress1(String customerAddress1) {
		this.customerAddress1 = customerAddress1;
	}
	public String getCustomerAddress2() {
		return customerAddress2;
	}
	public void setCustomerAddress2(String customerAddress2) {
		this.customerAddress2 = customerAddress2;
	}
	public Integer getRegisterAgreeContentNy() {
		return registerAgreeContentNy;
	}
	public void setRegisterAgreeContentNy(Integer registerAgreeContentNy) {
		this.registerAgreeContentNy = registerAgreeContentNy;
	}
	public Integer getCustomer_delNy() {
		return customer_delNy;
	}
	public void setCustomer_delNy(Integer customer_delNy) {
		this.customer_delNy = customer_delNy;
	}
	public Integer getCustomer_useNy() {
		return customer_useNy;
	}
	public void setCustomer_useNy(Integer customer_useNy) {
		this.customer_useNy = customer_useNy;
	}
	public String getCustomerDesc() {
		return customerDesc;
	}
	public void setCustomerDesc(String customerDesc) {
		this.customerDesc = customerDesc;
	}
	public Date getCustomerRgDate() {
		return customerRgDate;
	}
	public void setCustomerRgDate(Date customerRgDate) {
		this.customerRgDate = customerRgDate;
	}
	public Date getCustomerEditDate() {
		return customerEditDate;
	}
	public void setCustomerEditDate(Date customerEditDate) {
		this.customerEditDate = customerEditDate;
	}
	

}

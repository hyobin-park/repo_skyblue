package com.color.infra.pmembers;

import java.util.Date;

public class PmembersDto {
	
	private String seq;
	private Integer admin;
	private String name;
	private String id;
	private String password;
	private String gender;
	private Date birthDate;
	private String email;
	private String tel;
	private String desc;
	private Date regDate;
	private Date editDate;
//	-----
	public String getSeq() {
		return seq;
	}
	public void setSeq(String seq) {
		this.seq = seq;
	}
	public Integer getAdmin() {
		return admin;
	}
	public void setAdmin(Integer admin) {
		this.admin = admin;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
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
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public Date getRegDate() {
		return regDate;
	}
	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}
	public Date getEditDate() {
		return editDate;
	}
	public void setEditDate(Date editDate) {
		this.editDate = editDate;
	}
	
}

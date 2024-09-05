package com.color.infra.pmembers;

import java.util.Date;

public class PmembersDto {
	
	private String seq;
	private Integer admin;
	private String pmembers_name;
	private String pmembers_id;
	private String pmembers_password;
	private String pmembers_gender;
	private Date pmembers_birthDate;
	private String pmembers_email;
	private String pmembers_tel;
	private String pmembers_desc;
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
	public String getPmembers_name() {
		return pmembers_name;
	}
	public void setPmembers_name(String pmembers_name) {
		this.pmembers_name = pmembers_name;
	}
	public String getPmembers_id() {
		return pmembers_id;
	}
	public void setPmembers_id(String pmembers_id) {
		this.pmembers_id = pmembers_id;
	}
	public String getPmembers_password() {
		return pmembers_password;
	}
	public void setPmembers_password(String pmembers_password) {
		this.pmembers_password = pmembers_password;
	}
	public String getPmembers_gender() {
		return pmembers_gender;
	}
	public void setPmembers_gender(String pmembers_gender) {
		this.pmembers_gender = pmembers_gender;
	}
	public Date getPmembers_birthDate() {
		return pmembers_birthDate;
	}
	public void setPmembers_birthDate(Date pmembers_birthDate) {
		this.pmembers_birthDate = pmembers_birthDate;
	}
	public String getPmembers_email() {
		return pmembers_email;
	}
	public void setPmembers_email(String pmembers_email) {
		this.pmembers_email = pmembers_email;
	}
	public String getPmembers_tel() {
		return pmembers_tel;
	}
	public void setPmembers_tel(String pmembers_tel) {
		this.pmembers_tel = pmembers_tel;
	}
	public String getPmembers_desc() {
		return pmembers_desc;
	}
	public void setPmembers_desc(String pmembers_desc) {
		this.pmembers_desc = pmembers_desc;
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

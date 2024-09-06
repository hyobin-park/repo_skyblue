package com.color.infra.code;

import java.util.Date;

public class CodeDto {
	
	private String ifcdSeq;
	private String ifcdName;
	private Integer ifcdUseNy;
	private Integer ifcdOrder;
	private String ifcdDesc;
	private Integer ifcdDelNy;
	private Date ifcdRgDate;
	private Date ifcdEditDate;
	private String codegroup_ifcgSeq;
	
//	CodeGroup에서 가져올 데이터 추가 및 getter/setter 하기
	private String ifcgSeq;
	private String ifcgName;
	
//	----- getter/setter -----
	public String getIfcdSeq() {
		return ifcdSeq;
	}
	public void setIfcdSeq(String ifcdSeq) {
		this.ifcdSeq = ifcdSeq;
	}
	public String getIfcdName() {
		return ifcdName;
	}
	public void setIfcdName(String ifcdName) {
		this.ifcdName = ifcdName;
	}
	public Integer getIfcdUseNy() {
		return ifcdUseNy;
	}
	public void setIfcdUseNy(Integer ifcdUseNy) {
		this.ifcdUseNy = ifcdUseNy;
	}
	public Integer getIfcdOrder() {
		return ifcdOrder;
	}
	public void setIfcdOrder(Integer ifcdOrder) {
		this.ifcdOrder = ifcdOrder;
	}
	public String getIfcdDesc() {
		return ifcdDesc;
	}
	public void setIfcdDesc(String ifcdDesc) {
		this.ifcdDesc = ifcdDesc;
	}
	public Integer getIfcdDelNy() {
		return ifcdDelNy;
	}
	public void setIfcdDelNy(Integer ifcdDelNy) {
		this.ifcdDelNy = ifcdDelNy;
	}
	public Date getIfcdRgDate() {
		return ifcdRgDate;
	}
	public void setIfcdRgDate(Date ifcdRgDate) {
		this.ifcdRgDate = ifcdRgDate;
	}
	public Date getIfcdEditDate() {
		return ifcdEditDate;
	}
	public void setIfcdEditDate(Date ifcdEditDate) {
		this.ifcdEditDate = ifcdEditDate;
	}
	public String getCodegroup_ifcgSeq() {
		return codegroup_ifcgSeq;
	}
	public void setCodegroup_ifcgSeq(String codegroup_ifcgSeq) {
		this.codegroup_ifcgSeq = codegroup_ifcgSeq;
	}
	public String getIfcgSeq() {
		return ifcgSeq;
	}
	public void setIfcgSeq(String ifcgSeq) {
		this.ifcgSeq = ifcgSeq;
	}
	public String getIfcgName() {
		return ifcgName;
	}
	public void setIfcgName(String ifcgName) {
		this.ifcgName = ifcgName;
	}
	
}

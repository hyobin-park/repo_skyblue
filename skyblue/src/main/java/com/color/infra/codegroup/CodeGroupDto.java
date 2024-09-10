package com.color.infra.codegroup;

import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

public class CodeGroupDto {

	private String ifcgSeq;
	private String ifcgName;
	private Integer ifcgUseNy;
	private Integer ifcgOrder;
	private Integer ifcgDelNy;
	private String ifcgDesc;
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private Date ifcgRgDate;
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private Date ifcgEditDate;
	
	private Integer ifcdSeqCount;
	
	//	----- getter/setter -----	
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
	public Integer getIfcgUseNy() {
		return ifcgUseNy;
	}
	public void setIfcgUseNy(Integer ifcgUseNy) {
		this.ifcgUseNy = ifcgUseNy;
	}
	public Integer getIfcgOrder() {
		return ifcgOrder;
	}
	public void setIfcgOrder(Integer ifcgOrder) {
		this.ifcgOrder = ifcgOrder;
	}
	public Integer getIfcgDelNy() {
		return ifcgDelNy;
	}
	public void setIfcgDelNy(Integer ifcgDelNy) {
		this.ifcgDelNy = ifcgDelNy;
	}
	public String getIfcgDesc() {
		return ifcgDesc;
	}
	public void setIfcgDesc(String ifcgDesc) {
		this.ifcgDesc = ifcgDesc;
	}
	public Date getIfcgRgDate() {
		return ifcgRgDate;
	}
	public void setIfcgRgDate(Date ifcgRgDate) {
		this.ifcgRgDate = ifcgRgDate;
	}
	public Date getIfcgEditDate() {
		return ifcgEditDate;
	}
	public void setIfcgEditDate(Date ifcgEditDate) {
		this.ifcgEditDate = ifcgEditDate;
	}
	public Integer getIfcdSeqCount() {
		return ifcdSeqCount;
	}
	public void setIfcdSeqCount(Integer ifcdSeqCount) {
		this.ifcdSeqCount = ifcdSeqCount;
	}
}

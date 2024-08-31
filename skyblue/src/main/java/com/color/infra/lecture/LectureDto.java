package com.color.infra.lecture;

import java.util.Date;

public class LectureDto {

	private String seq;
	private String type;
	private String title;
	private Integer tuition;
	private String instructor;
	private Date classRegDate;
	private Date classRegEndDate;
	private Date classStartDate;
	private Date classEndDate;
	private String place;
	private String classDesc;
	private Date regDate;
	private Date editDate;
//	------
	public String getSeq() {
		return seq;
	}
	public void setSeq(String seq) {
		this.seq = seq;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Integer getTuition() {
		return tuition;
	}
	public void setTuition(Integer tuition) {
		this.tuition = tuition;
	}
	public String getInstructor() {
		return instructor;
	}
	public void setInstructor(String instructor) {
		this.instructor = instructor;
	}
	public Date getClassRegDate() {
		return classRegDate;
	}
	public void setClassRegDate(Date classRegDate) {
		this.classRegDate = classRegDate;
	}
	public Date getClassRegEndDate() {
		return classRegEndDate;
	}
	public void setClassRegEndDate(Date classRegEndDate) {
		this.classRegEndDate = classRegEndDate;
	}
	public Date getClassStartDate() {
		return classStartDate;
	}
	public void setClassStartDate(Date classStartDate) {
		this.classStartDate = classStartDate;
	}
	public Date getClassEndDate() {
		return classEndDate;
	}
	public void setClassEndDate(Date classEndDate) {
		this.classEndDate = classEndDate;
	}
	public String getPlace() {
		return place;
	}
	public void setPlace(String place) {
		this.place = place;
	}
	public String getClassDesc() {
		return classDesc;
	}
	public void setClassDesc(String classDesc) {
		this.classDesc = classDesc;
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

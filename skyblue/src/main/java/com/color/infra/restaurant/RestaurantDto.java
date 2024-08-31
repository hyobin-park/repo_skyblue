package com.color.infra.restaurant;

import java.sql.Time;
import java.util.Date;

public class RestaurantDto {
	
	private String seq;
	private String type;
	private String name;
	private Time openTime;
	private Time closeTime;
	private String tel;
	private String website;
	private Integer parking;
	private Integer reservation;
	private Integer corkageFree;
	private String introduction;
	private Date regDate;
	private Date EditDate;
//	-----
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
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Time getOpenTime() {
		return openTime;
	}
	public void setOpenTime(Time openTime) {
		this.openTime = openTime;
	}
	public Time getCloseTime() {
		return closeTime;
	}
	public void setCloseTime(Time closeTime) {
		this.closeTime = closeTime;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getWebsite() {
		return website;
	}
	public void setWebsite(String website) {
		this.website = website;
	}
	public Integer getParking() {
		return parking;
	}
	public void setParking(Integer parking) {
		this.parking = parking;
	}
	public Integer getReservation() {
		return reservation;
	}
	public void setReservation(Integer reservation) {
		this.reservation = reservation;
	}
	public Integer getCorkageFree() {
		return corkageFree;
	}
	public void setCorkageFree(Integer corkageFree) {
		this.corkageFree = corkageFree;
	}
	public String getIntroduction() {
		return introduction;
	}
	public void setIntroduction(String introduction) {
		this.introduction = introduction;
	}
	public Date getRegDate() {
		return regDate;
	}
	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}
	public Date getEditDate() {
		return EditDate;
	}
	public void setEditDate(Date editDate) {
		EditDate = editDate;
	}

}

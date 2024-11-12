package com.color.infra.rooms;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class RoomsDto {
	
	private String roomSeq;
	private String roomType;
	private Integer price;
	private Integer status;
	private String roomDesc;
	private Integer rooms_delNy;
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private Date roomRgDate;
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private Date roomEditDate;
	private String Hotel_seq;
	private String bedType;
	private Integer PeopleStay;
	
	// Hotel
	private String hotelName;
	
	// ------- getter/setter -------
	public String getRoomSeq() {
		return roomSeq;
	}
	public void setRoomSeq(String roomSeq) {
		this.roomSeq = roomSeq;
	}
	public String getRoomType() {
		return roomType;
	}
	public void setRoomType(String roomType) {
		this.roomType = roomType;
	}
	public Integer getPrice() {
		return price;
	}
	public void setPrice(Integer price) {
		this.price = price;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public Integer getRooms_delNy() {
		return rooms_delNy;
	}
	public void setRooms_delNy(Integer rooms_delNy) {
		this.rooms_delNy = rooms_delNy;
	}
	public String getHotel_seq() {
		return Hotel_seq;
	}
	public void setHotel_seq(String hotel_seq) {
		Hotel_seq = hotel_seq;
	}
	public String getRoomDesc() {
		return roomDesc;
	}
	public void setRoomDesc(String roomDesc) {
		this.roomDesc = roomDesc;
	}
	public Date getRoomRgDate() {
		return roomRgDate;
	}
	public void setRoomRgDate(Date roomRgDate) {
		this.roomRgDate = roomRgDate;
	}
	public Date getRoomEditDate() {
		return roomEditDate;
	}
	public void setRoomEditDate(Date roomEditDate) {
		this.roomEditDate = roomEditDate;
	}
	public String getHotelName() {
		return hotelName;
	}
	public void setHotelName(String hotelName) {
		this.hotelName = hotelName;
	}
	public String getBedType() {
		return bedType;
	}
	public void setBedType(String bedType) {
		this.bedType = bedType;
	}
	public Integer getPeopleStay() {
		return PeopleStay;
	}
	public void setPeopleStay(Integer peopleStay) {
		PeopleStay = peopleStay;
	}
	
	
}

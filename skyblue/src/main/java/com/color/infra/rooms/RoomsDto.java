package com.color.infra.rooms;

public class RoomsDto {
	
	private String roomSeq;
	private String roomType;
	private Integer price;
	private String status;
	private Integer rooms_delNy;
	private String Hotel_seq;
	
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
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
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
	
}

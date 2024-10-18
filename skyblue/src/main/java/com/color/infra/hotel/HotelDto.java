package com.color.infra.hotel;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class HotelDto {
	
	private String hotelSeq;
	private String hotelName;
	private String hotelZipCode;
	private String hotelAddress1;
	private String hotelAddress2;
	private String site;
	private Integer stars;
	private Integer swimmingPoolNy;
	private Integer fitnessCenterNy;
	private Integer roomServiceNy;
	private Integer spaNy;
	private Integer wifiNy;
	private Integer parkingNy;
	private Integer hvacNy;
	private Integer smokingAreaNy;
	private Integer petsNy;
	private Integer hotel_delNy;
	private Integer hotel_useNy;
	private String hotelDesc;
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private Date hotelRgDate;
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private Date hotelEditDate;
	
	
	//	----- getter/setter -----
	public String getHotelSeq() {
		return hotelSeq;
	}
	public void setHotelSeq(String hotelSeq) {
		this.hotelSeq = hotelSeq;
	}
	public String getHotelName() {
		return hotelName;
	}
	public void setHotelName(String hotelName) {
		this.hotelName = hotelName;
	}
	public String getHotelZipCode() {
		return hotelZipCode;
	}
	public void setHotelZipCode(String hotelZipCode) {
		this.hotelZipCode = hotelZipCode;
	}
	public String getHotelAddress1() {
		return hotelAddress1;
	}
	public void setHotelAddress1(String hotelAddress1) {
		this.hotelAddress1 = hotelAddress1;
	}
	public String getHotelAddress2() {
		return hotelAddress2;
	}
	public void setHotelAddress2(String hotelAddress2) {
		this.hotelAddress2 = hotelAddress2;
	}
	public String getSite() {
		return site;
	}
	public void setSite(String site) {
		this.site = site;
	}
	public Integer getStars() {
		return stars;
	}
	public void setStars(Integer stars) {
		this.stars = stars;
	}
	public Integer getSwimmingPoolNy() {
		return swimmingPoolNy;
	}
	public void setSwimmingPoolNy(Integer swimmingPoolNy) {
		this.swimmingPoolNy = swimmingPoolNy;
	}
	public Integer getFitnessCenterNy() {
		return fitnessCenterNy;
	}
	public void setFitnessCenterNy(Integer fitnessCenterNy) {
		this.fitnessCenterNy = fitnessCenterNy;
	}
	public Integer getRoomServiceNy() {
		return roomServiceNy;
	}
	public void setRoomServiceNy(Integer roomServiceNy) {
		this.roomServiceNy = roomServiceNy;
	}
	public Integer getSpaNy() {
		return spaNy;
	}
	public void setSpaNy(Integer spaNy) {
		this.spaNy = spaNy;
	}
	public Integer getWifiNy() {
		return wifiNy;
	}
	public void setWifiNy(Integer wifiNy) {
		this.wifiNy = wifiNy;
	}
	public Integer getParkingNy() {
		return parkingNy;
	}
	public void setParkingNy(Integer parkingNy) {
		this.parkingNy = parkingNy;
	}
	public Integer getHvacNy() {
		return hvacNy;
	}
	public void setHvacNy(Integer hvacNy) {
		this.hvacNy = hvacNy;
	}
	public Integer getSmokingAreaNy() {
		return smokingAreaNy;
	}
	public void setSmokingAreaNy(Integer smokingAreaNy) {
		this.smokingAreaNy = smokingAreaNy;
	}
	public Integer getPetsNy() {
		return petsNy;
	}
	public void setPetsNy(Integer petsNy) {
		this.petsNy = petsNy;
	}
	public Integer getHotel_delNy() {
		return hotel_delNy;
	}
	public void setHotel_delNy(Integer hotel_delNy) {
		this.hotel_delNy = hotel_delNy;
	}
	public Integer getHotel_useNy() {
		return hotel_useNy;
	}
	public void setHotel_useNy(Integer hotel_useNy) {
		this.hotel_useNy = hotel_useNy;
	}
	public String getHotelDesc() {
		return hotelDesc;
	}
	public void setHotelDesc(String hotelDesc) {
		this.hotelDesc = hotelDesc;
	}
	public Date getHotelRgDate() {
		return hotelRgDate;
	}
	public void setHotelRgDate(Date hotelRgDate) {
		this.hotelRgDate = hotelRgDate;
	}
	public Date getHotelEditDate() {
		return hotelEditDate;
	}
	public void setHotelEditDate(Date hotelEditDate) {
		this.hotelEditDate = hotelEditDate;
	}
	
}

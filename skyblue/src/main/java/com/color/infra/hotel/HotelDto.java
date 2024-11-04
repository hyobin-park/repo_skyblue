package com.color.infra.hotel;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.multipart.MultipartFile;

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
	
	// rooms
	private String roomType;
	private Integer price;
	private String status;
	private String Hotel_seq;
	
	// files
	private MultipartFile uploadFile;
	private MultipartFile[] uploadFiles;
	private Integer seq;
	private Integer type;
	private Integer defaultNy;
	private Integer sort;
	private String path;
	private String originalName;
	private String uuidName;
	private String ext;
	private Integer size;
	private Integer delNy;
	private Integer pseq;
	private String regIp;
	private Integer regSeq;
	private Integer regDeviceCd;
	private Date regDateTime;
	private Date regDateTimeSvr;
	
	
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
	public String getHotel_seq() {
		return Hotel_seq;
	}
	public void setHotel_seq(String hotel_seq) {
		Hotel_seq = hotel_seq;
	}
	public MultipartFile getUploadFile() {
		return uploadFile;
	}
	public void setUploadFile(MultipartFile uploadFile) {
		this.uploadFile = uploadFile;
	}
	public MultipartFile[] getUploadFiles() {
		return uploadFiles;
	}
	public void setUploadFiles(MultipartFile[] uploadFiles) {
		this.uploadFiles = uploadFiles;
	}
	public Integer getSeq() {
		return seq;
	}
	public void setSeq(Integer seq) {
		this.seq = seq;
	}
	public Integer getType() {
		return type;
	}
	public void setType(Integer type) {
		this.type = type;
	}
	public Integer getDefaultNy() {
		return defaultNy;
	}
	public void setDefaultNy(Integer defaultNy) {
		this.defaultNy = defaultNy;
	}
	public Integer getSort() {
		return sort;
	}
	public void setSort(Integer sort) {
		this.sort = sort;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	public String getOriginalName() {
		return originalName;
	}
	public void setOriginalName(String originalName) {
		this.originalName = originalName;
	}
	public String getUuidName() {
		return uuidName;
	}
	public void setUuidName(String uuidName) {
		this.uuidName = uuidName;
	}
	public String getExt() {
		return ext;
	}
	public void setExt(String ext) {
		this.ext = ext;
	}
	public Integer getSize() {
		return size;
	}
	public void setSize(Integer size) {
		this.size = size;
	}
	public Integer getDelNy() {
		return delNy;
	}
	public void setDelNy(Integer delNy) {
		this.delNy = delNy;
	}
	public Integer getPseq() {
		return pseq;
	}
	public void setPseq(Integer pseq) {
		this.pseq = pseq;
	}
	public String getRegIp() {
		return regIp;
	}
	public void setRegIp(String regIp) {
		this.regIp = regIp;
	}
	public Integer getRegSeq() {
		return regSeq;
	}
	public void setRegSeq(Integer regSeq) {
		this.regSeq = regSeq;
	}
	public Integer getRegDeviceCd() {
		return regDeviceCd;
	}
	public void setRegDeviceCd(Integer regDeviceCd) {
		this.regDeviceCd = regDeviceCd;
	}
	public Date getRegDateTime() {
		return regDateTime;
	}
	public void setRegDateTime(Date regDateTime) {
		this.regDateTime = regDateTime;
	}
	public Date getRegDateTimeSvr() {
		return regDateTimeSvr;
	}
	public void setRegDateTimeSvr(Date regDateTimeSvr) {
		this.regDateTimeSvr = regDateTimeSvr;
	}
	
	
}

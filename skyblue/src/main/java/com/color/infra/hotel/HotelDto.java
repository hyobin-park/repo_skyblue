package com.color.infra.hotel;

import java.util.Date;
import java.util.List;

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
	private Integer minPrice;
	
	// rooms
	private String roomSeq;
	private String roomType;
	private Integer price;
	private String status;
	private String Hotel_seq;
	private String bedType;
	private Integer PeopleStay;
	
	// booking
	private String bookingSeq;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date checkInDate;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date checkOutDate;
	private Integer bkPayment;
	private Integer totalPrice;
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date paymentDate;
	private String bkDesc;
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date bkRegDate;
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date bkEditDate;
	private Integer bkDelNy;
	
	//bookingroom
	private String brSeq;
	private Integer brUseNy;
	private Integer brDelNy;
	private String rooms_roomSeq;
	private String booking_bookingSeq;
	private String[] room_Seqs;	// checkbox 선택된 meseq 배열
	
	// reviews
	private String reviewSeq;
	private Integer reStars;
    private String reTitle;
    private String reDesc;
    private Integer reDelNy;
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date reRegDate;
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date reEditDate;
    private String Customer_seq;
	
    // customer
    private String customerName;
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date birthDate;
    private String phoneNumber;
    private String email;
    
    
	// files
	private MultipartFile uploadFile;
	private MultipartFile[] uploadFiles;
	private Integer upSeq;
	private Integer upType;
	private Integer upDefaultNy;
	private Integer upSort;
	private String upPath;
	private String upOriginalName;
	private String upUuidName;
	private String upExt;
	private Long upSize;
	private Integer upDelNy;
	private Integer upCusSeq;
	private String upRegIp;
	private Integer upRegSeq;
	private Integer upRegDeviceCd;
	private Date upRegDateTime;
	private Date upRegDateTimeSvr;
	
	// review
	private String[] reStarsArr;
	
	
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
	public String getReviewSeq() {
		return reviewSeq;
	}
	public void setReviewSeq(String reviewSeq) {
		this.reviewSeq = reviewSeq;
	}
	public Integer getReStars() {
		return reStars;
	}
	public void setReStars(Integer reStars) {
		this.reStars = reStars;
	}
	public String getReTitle() {
		return reTitle;
	}
	public void setReTitle(String reTitle) {
		this.reTitle = reTitle;
	}
	public String getReDesc() {
		return reDesc;
	}
	public void setReDesc(String reDesc) {
		this.reDesc = reDesc;
	}
	public Integer getReDelNy() {
		return reDelNy;
	}
	public void setReDelNy(Integer reDelNy) {
		this.reDelNy = reDelNy;
	}
	public Date getReRegDate() {
		return reRegDate;
	}
	public void setReRegDate(Date reRegDate) {
		this.reRegDate = reRegDate;
	}
	public Date getReEditDate() {
		return reEditDate;
	}
	public void setReEditDate(Date reEditDate) {
		this.reEditDate = reEditDate;
	}
	public String getCustomer_seq() {
		return Customer_seq;
	}
	public void setCustomer_seq(String customer_seq) {
		Customer_seq = customer_seq;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public Integer getMinPrice() {
		return minPrice;
	}
	public void setMinPrice(Integer minPrice) {
		this.minPrice = minPrice;
	}
	public Integer getUpSeq() {
		return upSeq;
	}
	public void setUpSeq(Integer upSeq) {
		this.upSeq = upSeq;
	}
	public Integer getUpType() {
		return upType;
	}
	public void setUpType(Integer upType) {
		this.upType = upType;
	}
	public Integer getUpDefaultNy() {
		return upDefaultNy;
	}
	public void setUpDefaultNy(Integer upDefaultNy) {
		this.upDefaultNy = upDefaultNy;
	}
	public Integer getUpSort() {
		return upSort;
	}
	public void setUpSort(Integer upSort) {
		this.upSort = upSort;
	}
	public String getUpPath() {
		return upPath;
	}
	public void setUpPath(String upPath) {
		this.upPath = upPath;
	}
	public String getUpOriginalName() {
		return upOriginalName;
	}
	public void setUpOriginalName(String upOriginalName) {
		this.upOriginalName = upOriginalName;
	}
	public String getUpUuidName() {
		return upUuidName;
	}
	public void setUpUuidName(String upUuidName) {
		this.upUuidName = upUuidName;
	}
	public String getUpExt() {
		return upExt;
	}
	public void setUpExt(String upExt) {
		this.upExt = upExt;
	}
	public Long getUpSize() {
		return upSize;
	}
	public void setUpSize(Long upSize) {
		this.upSize = upSize;
	}
	public Integer getUpDelNy() {
		return upDelNy;
	}
	public void setUpDelNy(Integer upDelNy) {
		this.upDelNy = upDelNy;
	}
	public Integer getUpCusSeq() {
		return upCusSeq;
	}
	public void setUpCusSeq(Integer upCusSeq) {
		this.upCusSeq = upCusSeq;
	}
	public String getUpRegIp() {
		return upRegIp;
	}
	public void setUpRegIp(String upRegIp) {
		this.upRegIp = upRegIp;
	}
	public Integer getUpRegSeq() {
		return upRegSeq;
	}
	public void setUpRegSeq(Integer upRegSeq) {
		this.upRegSeq = upRegSeq;
	}
	public Integer getUpRegDeviceCd() {
		return upRegDeviceCd;
	}
	public void setUpRegDeviceCd(Integer upRegDeviceCd) {
		this.upRegDeviceCd = upRegDeviceCd;
	}
	public Date getUpRegDateTime() {
		return upRegDateTime;
	}
	public void setUpRegDateTime(Date upRegDateTime) {
		this.upRegDateTime = upRegDateTime;
	}
	public Date getUpRegDateTimeSvr() {
		return upRegDateTimeSvr;
	}
	public void setUpRegDateTimeSvr(Date upRegDateTimeSvr) {
		this.upRegDateTimeSvr = upRegDateTimeSvr;
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
	public String[] getReStarsArr() {
		return reStarsArr;
	}
	public void setReStarsArr(String[] reStarsArr) {
		this.reStarsArr = reStarsArr;
	}
	public String getBookingSeq() {
		return bookingSeq;
	}
	public void setBookingSeq(String bookingSeq) {
		this.bookingSeq = bookingSeq;
	}
	public Date getCheckInDate() {
		return checkInDate;
	}
	public void setCheckInDate(Date checkInDate) {
		this.checkInDate = checkInDate;
	}
	public Date getCheckOutDate() {
		return checkOutDate;
	}
	public void setCheckOutDate(Date checkOutDate) {
		this.checkOutDate = checkOutDate;
	}
	public Integer getBkPayment() {
		return bkPayment;
	}
	public void setBkPayment(Integer bkPayment) {
		this.bkPayment = bkPayment;
	}
	public Integer getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(Integer totalPrice) {
		this.totalPrice = totalPrice;
	}
	public Date getPaymentDate() {
		return paymentDate;
	}
	public void setPaymentDate(Date paymentDate) {
		this.paymentDate = paymentDate;
	}
	public String getBkDesc() {
		return bkDesc;
	}
	public void setBkDesc(String bkDesc) {
		this.bkDesc = bkDesc;
	}
	public Date getBkRegDate() {
		return bkRegDate;
	}
	public void setBkRegDate(Date bkRegDate) {
		this.bkRegDate = bkRegDate;
	}
	public Date getBkEditDate() {
		return bkEditDate;
	}
	public void setBkEditDate(Date bkEditDate) {
		this.bkEditDate = bkEditDate;
	}
	public Integer getBkDelNy() {
		return bkDelNy;
	}
	public void setBkDelNy(Integer bkDelNy) {
		this.bkDelNy = bkDelNy;
	}
	public String getBrSeq() {
		return brSeq;
	}
	public void setBrSeq(String brSeq) {
		this.brSeq = brSeq;
	}
	public Integer getBrUseNy() {
		return brUseNy;
	}
	public void setBrUseNy(Integer brUseNy) {
		this.brUseNy = brUseNy;
	}
	public Integer getBrDelNy() {
		return brDelNy;
	}
	public void setBrDelNy(Integer brDelNy) {
		this.brDelNy = brDelNy;
	}
	public String getRooms_roomSeq() {
		return rooms_roomSeq;
	}
	public void setRooms_roomSeq(String rooms_roomSeq) {
		this.rooms_roomSeq = rooms_roomSeq;
	}
	public String getBooking_bookingSeq() {
		return booking_bookingSeq;
	}
	public void setBooking_bookingSeq(String booking_bookingSeq) {
		this.booking_bookingSeq = booking_bookingSeq;
	}
	public String[] getRoom_Seqs() {
		return room_Seqs;
	}
	public void setRoom_Seqs(String[] room_Seqs) {
		this.room_Seqs = room_Seqs;
	}
	public String getRoomSeq() {
		return roomSeq;
	}
	public void setRoomSeq(String roomSeq) {
		this.roomSeq = roomSeq;
	}
	public Date getBirthDate() {
		return birthDate;
	}
	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
}

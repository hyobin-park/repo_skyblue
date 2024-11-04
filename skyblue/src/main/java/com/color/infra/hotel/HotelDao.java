package com.color.infra.hotel;

import java.util.List;
import org.springframework.stereotype.Repository;

@Repository
public interface HotelDao {
	
	//HotelList
	public List<HotelDto> hotelList(HotelVo hotelVo);
	
	//insert
	public int hotelInsert(HotelDto hotelDto);
	
	//selectOne
	public HotelDto selectOne(HotelDto hotelDto);
	
	//update
	public int hotelUpdate(HotelDto hotelDto);
	
	//uelete
	public int hotelUelete(HotelDto hotelDto);
	
	//delete
	public int hotelDelete(HotelDto hotelDto);
	
	//selectOneCount
	public int selectOneCount(HotelVo hotelVo);
	
	// file 첨부
	public void insertUploaded(HotelDto hotelDto);
	
}

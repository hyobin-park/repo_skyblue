package com.color.infra.hotel;

import java.util.List;
import org.springframework.stereotype.Repository;

@Repository
public interface HotelDao {
	
	//HotelList
	public List<HotelDto> hotelList();
	
	//insert
	public int hotelInsert(HotelDto hotelDto);

}

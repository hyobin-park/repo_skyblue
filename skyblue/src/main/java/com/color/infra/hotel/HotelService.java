package com.color.infra.hotel;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HotelService {
	
	@Autowired
	private HotelDao hotelDao;
	
	public List<HotelDto> hotelList() {
		List<HotelDto> hotels = hotelDao.hotelList();
		return hotels;
	}
	
	public int hotelInsert(HotelDto hotelDto) {
		return hotelDao.hotelInsert(hotelDto);
	}
	

}

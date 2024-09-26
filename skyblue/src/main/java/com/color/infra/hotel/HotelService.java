package com.color.infra.hotel;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HotelService {
	
	@Autowired
	private HotelDao hotelDao;
	
	public List<HotelDto> hotelList(HotelVo hotelVo) {
		return hotelDao.hotelList(hotelVo);
	}
	
	public int hotelInsert(HotelDto hotelDto) {
		return hotelDao.hotelInsert(hotelDto);
	}
	
	public HotelDto selectOne(HotelDto hotelDto) {
		return hotelDao.selectOne(hotelDto);
	}
	
	public int hotelUpdate(HotelDto hotelDto) {
		return hotelDao.hotelUpdate(hotelDto);
	}
	
	public int hotelUelete(HotelDto hotelDto) {
		return hotelDao.hotelUelete(hotelDto);
	}
	
	public int hotelDelete(HotelDto hotelDto) {
		return hotelDao.hotelDelete(hotelDto);
	}
	
	public int selectOneCount(HotelVo hotelVo) {
		return hotelDao.selectOneCount(hotelVo);
	}
}

package com.color.infra.restaurant;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RestaurantService {
	
	@Autowired
	private RestaurantDao restaurantDao;
	
	public List<RestaurantDto> selectRes() {
		return restaurantDao.selectRes();
	}
	
	

}

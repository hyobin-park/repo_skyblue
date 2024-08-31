package com.color.infra.restaurant;

import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
public interface RestaurantDao {

	public List<RestaurantDto> selectRes();
	
}

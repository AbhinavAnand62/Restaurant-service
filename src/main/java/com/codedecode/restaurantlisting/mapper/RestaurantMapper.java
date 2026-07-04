package com.codedecode.restaurantlisting.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.codedecode.restaurantlisting.dto.RestaurantDto;
import com.codedecode.restaurantlisting.entity.Restaurant;

@Mapper(componentModel = "spring")
public interface RestaurantMapper {

	// we will have two mapperh here
	// 1. to map RestaurantDto to restaurant
	//2. Restaurant to RestaurantDto
	
	//
	
	RestaurantMapper INTANCE = Mappers.getMapper(RestaurantMapper.class);
	
	RestaurantDto mapRestaurantToRestaurantDto(Restaurant restaurant);
	Restaurant mapRestaurantDtoTorestaurant(RestaurantDto restaurantDto);
	
}

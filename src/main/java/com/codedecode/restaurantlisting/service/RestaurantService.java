package com.codedecode.restaurantlisting.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codedecode.restaurantlisting.dto.RestaurantDto;
import com.codedecode.restaurantlisting.entity.Restaurant;
import com.codedecode.restaurantlisting.mapper.RestaurantMapper;
import com.codedecode.restaurantlisting.repo.RestaurantRepo;

@Service
public class RestaurantService {
	
	@Autowired
	RestaurantRepo restaurantRepo;

	@Autowired
	RestaurantMapper restaurantMapper;
	
	public List<RestaurantDto> findAllRestaurants() {
		List<Restaurant> allRestaurants=restaurantRepo.findAll();
		//map the entity data with DTO using mapstruct
		
		List<RestaurantDto> allRestaurantDtos=allRestaurants.stream().map(restaurant -> restaurantMapper.mapRestaurantToRestaurantDto(restaurant))
				.collect(Collectors.toList());
		
		return allRestaurantDtos;
	}

	public RestaurantDto addRestaurantInDB(RestaurantDto restaurantDto) {
		Restaurant restaurant = restaurantMapper.mapRestaurantDtoTorestaurant(restaurantDto);
		restaurant=restaurantRepo.save(restaurant);
		RestaurantDto addedRestaurantDto = restaurantMapper.mapRestaurantToRestaurantDto(restaurant);
		
		return addedRestaurantDto;
	}

	public RestaurantDto fetchRestaurantByID(int id) {
		Optional<Restaurant> res=restaurantRepo.findById(id);
		RestaurantDto dto;
		if(res.isPresent())
		{
			dto=restaurantMapper.mapRestaurantToRestaurantDto(res.get());
		}else
		{
			dto=null;
		}
		
		return dto;
	}

}

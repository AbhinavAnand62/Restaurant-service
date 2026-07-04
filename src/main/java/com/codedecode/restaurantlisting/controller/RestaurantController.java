package com.codedecode.restaurantlisting.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.codedecode.restaurantlisting.dto.RestaurantDto;
import com.codedecode.restaurantlisting.entity.Restaurant;
import com.codedecode.restaurantlisting.service.RestaurantService;

@RestController
@RequestMapping("/restaurant")
public class RestaurantController {
	
	@Autowired
	private RestaurantService restaurantService;
	
	@GetMapping("/fetchAllRestaurants")
	public ResponseEntity<List<RestaurantDto>> fetchAllRestaurants() {
		List<RestaurantDto> allRestaurants= restaurantService.findAllRestaurants();
		return new ResponseEntity<List<RestaurantDto>>(allRestaurants,HttpStatusCode.valueOf(200));
	}
	
	@PostMapping("/addRestaurant")
	public ResponseEntity<RestaurantDto> saveRestaurant(@RequestBody RestaurantDto restaurantDto){
		RestaurantDto addedRestaurant = restaurantService.addRestaurantInDB(restaurantDto);
		return new ResponseEntity<>(addedRestaurant,HttpStatusCode.valueOf(201));
		
	}
	
	@GetMapping("/fetchRestaurantByID/{id}")
	public ResponseEntity<RestaurantDto> fetchRestaurantByID(@PathVariable int id) {
		RestaurantDto dto= restaurantService.fetchRestaurantByID(id);
		if(dto!=null) {
			return new ResponseEntity<>(dto,HttpStatusCode.valueOf(200));
		}
		return new ResponseEntity<>(dto,HttpStatusCode.valueOf(404));
	}

}

package com.codedecode.restaurantlisting.dto;

public class RestaurantDto {
	private int id;
	private String name;
	private String city;
	private String address;
	private String restaurantDescription;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getRestaurantDescription() {
		return restaurantDescription;
	}
	public void setRestaurantDescription(String restaurantDescription) {
		this.restaurantDescription = restaurantDescription;
	}
	public RestaurantDto(int id, String name, String city, String address, String restaurantDescription) {
		super();
		this.id = id;
		this.name = name;
		this.city = city;
		this.address = address;
		this.restaurantDescription = restaurantDescription;
	}
	public RestaurantDto() {
		super();
		// adding comments just to push this file to git.
	}
	
	
}

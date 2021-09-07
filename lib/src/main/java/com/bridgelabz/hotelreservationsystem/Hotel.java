package com.bridgelabz.hotelreservationsystem;

import java.util.HashMap;

public class Hotel {

	public String hotelName;
	public int hotelRating;
	public HashMap<CustomerType, Rates> rates;
	
	
	public Hotel( String hotelName, int hotelRating, HashMap<CustomerType, Rates> rates) {
		this.hotelRating = hotelRating;
		this.hotelName = hotelName;
		this.rates = rates;
	}
	
}

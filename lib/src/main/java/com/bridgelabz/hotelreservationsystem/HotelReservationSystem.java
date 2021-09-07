package com.bridgelabz.hotelreservationsystem;

import java.util.ArrayList;

public class HotelReservationSystem {
	
	private ArrayList<Hotel> hotels;

	public HotelReservationSystem() {
		this.hotels = new ArrayList<Hotel>();
	}
	
	public boolean addHotel(Hotel hotel) {
		return this.hotels.add(hotel);
	}
	
	
}

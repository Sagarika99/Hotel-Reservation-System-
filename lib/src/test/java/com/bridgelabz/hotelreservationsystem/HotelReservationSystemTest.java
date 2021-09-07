package com.bridgelabz.hotelreservationsystem;

import java.util.HashMap;
import org.junit.Test;

public class HotelReservationSystemTest {

	@Test
	public void addHotel_And_addRates(){
		HotelReservationSystem hotel = new HotelReservationSystem();
		
		HashMap<CustomerType, Rates> customerTypeRateMap = new HashMap<CustomerType, Rates>();
		customerTypeRateMap.put(CustomerType.REGULAR, new Rates(110,90));
		customerTypeRateMap.put(CustomerType.REWARDS, new Rates(80,80));
		Hotel lakewood = new Hotel("Lakewood",3 ,customerTypeRateMap);
		
		customerTypeRateMap = new HashMap<CustomerType, Rates>();
		customerTypeRateMap.put(CustomerType.REGULAR, new Rates(160,40));
		customerTypeRateMap.put(CustomerType.REWARDS, new Rates(110,50));
		Hotel bridgewood = new Hotel("Bridgewood",4 ,customerTypeRateMap);
				
	    customerTypeRateMap = new HashMap<CustomerType, Rates>();
		customerTypeRateMap.put(CustomerType.REGULAR, new Rates(110,90));
		customerTypeRateMap.put(CustomerType.REWARDS, new Rates(80,80));
		Hotel ridgewood = new Hotel("Ridgewood",5 ,customerTypeRateMap);
		
		hotel.addHotel(lakewood);
		hotel.addHotel(bridgewood);
		hotel.addHotel(ridgewood);
		
	}
}

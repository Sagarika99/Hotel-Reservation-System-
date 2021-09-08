package com.bridgelabz.hotelreservationsystem;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Scanner;
import org.junit.Before;
import org.junit.Test;
import org.junit.Assert;

public class HotelReservationSystemTest {

	HotelReservationSystem hotel = new HotelReservationSystem();
	
	@Before
	public void addHotel_And_addRates(){
		
		HashMap<CustomerType, Rates> customerTypeRateMap = new HashMap<CustomerType, Rates>();
		customerTypeRateMap.put(CustomerType.REGULAR, new Rates(110,90));
		customerTypeRateMap.put(CustomerType.REWARDS, new Rates(80,80));
		Hotel lakewood = new Hotel("Lakewood",3 ,customerTypeRateMap);
		
		customerTypeRateMap = new HashMap<CustomerType, Rates>();
		customerTypeRateMap.put(CustomerType.REGULAR, new Rates(150,50));
		customerTypeRateMap.put(CustomerType.REWARDS, new Rates(110,50));
		Hotel bridgewood = new Hotel("Bridgewood",4 ,customerTypeRateMap);
				
	    customerTypeRateMap = new HashMap<CustomerType, Rates>();
		customerTypeRateMap.put(CustomerType.REGULAR, new Rates(220,150));
		customerTypeRateMap.put(CustomerType.REWARDS, new Rates(100,40));
		Hotel ridgewood = new Hotel("Ridgewood",5 ,customerTypeRateMap);
		
		hotel.addHotel(lakewood);
		hotel.addHotel(bridgewood);
		hotel.addHotel(ridgewood);
	}
	
    @Test
    public void whenGivenDateRange_ShouldReturnCheapestHotel() {
    	DateTimeFormatter df = DateTimeFormatter.ofPattern("ddMMMyyyy");    	
    	LocalDate d1 = LocalDate.of(2020,9,11);
    	LocalDate d2 = LocalDate.of(2020,9,12);
        hotel.cheapeastHotel(d1,d2);
    }
    
    @Test
    public void whenGivenDateRange_ShouldReturnBestRatingCheapestHotel() {
    	DateTimeFormatter df = DateTimeFormatter.ofPattern("ddMMMyyyy");    	
    	LocalDate d1 = LocalDate.of(2020,9,11);
    	LocalDate d2 = LocalDate.of(2020,9,12);
        hotel.bestRatingCheapestHotel(d1,d2);
    }
		
}

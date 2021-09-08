package com.bridgelabz.hotelreservationsystem;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Scanner;

import org.junit.Before;
import org.junit.Test;

public class HotelReservationSystemTest {

	HotelReservationSystem hotel = new HotelReservationSystem();
	
	@Before
	public void addHotel_And_addRates(){
		
		HashMap<CustomerType, Rates> customerTypeRateMap = new HashMap<CustomerType, Rates>();
		customerTypeRateMap.put(CustomerType.REGULAR, new Rates(110,90));
		customerTypeRateMap.put(CustomerType.REWARDS, new Rates(80,80));
		Hotel lakewood = new Hotel("Lakewood",3 ,customerTypeRateMap);
		
		customerTypeRateMap = new HashMap<CustomerType, Rates>();
		customerTypeRateMap.put(CustomerType.REGULAR, new Rates(160,60));
		customerTypeRateMap.put(CustomerType.REWARDS, new Rates(110,50));
		Hotel bridgewood = new Hotel("Bridgewood",4 ,customerTypeRateMap);
				
	    customerTypeRateMap = new HashMap<CustomerType, Rates>();
		customerTypeRateMap.put(CustomerType.REGULAR, new Rates(220,150));
		customerTypeRateMap.put(CustomerType.REWARDS, new Rates(100,40));
		Hotel ridgewood = new Hotel("Ridgewood",5 ,customerTypeRateMap);
		
		hotel.addHotel(lakewood);
		hotel.addHotel(bridgewood);
		hotel.addHotel(ridgewood);
		
		//hotel.toPrint();
	}
	
    @Test
    public void nameAndPrice_OfChipestHotels() {
    	DateTimeFormatter df = DateTimeFormatter.ofPattern("ddMMMyyyy");
    	Scanner sc = new Scanner(System.in);
    	System.out.println("Start Date:");
    	String date1 = sc.nextLine();
    	
    	System.out.println("End Date:");
    	String date2 = sc.nextLine();
    	
        LocalDate d1 = LocalDate.parse(date1,df);
        LocalDate d2 = LocalDate.parse(date2,df);
        hotel.cheapeastHotel(d1,d2);
    }
		
}

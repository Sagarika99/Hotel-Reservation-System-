package com.bridgelabz.hotelreservationsystem;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class HotelReservationSystem {
	
	public ArrayList<Hotel> hotels = new ArrayList<Hotel>();

	public HotelReservationSystem() {
		this.hotels = new ArrayList<Hotel>();
	}
	
	public void addHotel(Hotel hotel) {
		hotels.add(hotel);
	}
	
    public void cheapeastHotel(LocalDate startDate, LocalDate lastDate){
        ArrayList<LocalDate> dateArray = new ArrayList<LocalDate>(3);

        dateArray.add(startDate);
        long daysBetween = ChronoUnit.DAYS.between(startDate,lastDate);

        while (daysBetween>0){
        	dateArray.add(dateArray.get(dateArray.size()-1).plusDays(1));
            daysBetween--;
        }
        
        Integer[] price ={0,0,0};
        for (int i=0; i<dateArray.size(); i++){
            for (int j=0; j<hotels.size(); j++) {

                if (dateArray.get(i).getDayOfWeek().equals(DayOfWeek.SATURDAY) || dateArray.get(i).getDayOfWeek().equals(DayOfWeek.SUNDAY)){
                    price[j] += hotels.get(j).rates.get(CustomerType.REGULAR).weekEndRate;
                }
                else
                    price[j] += hotels.get(j).rates.get(CustomerType.REGULAR).weekDayRate;
            }
        }

        int n = Arrays.asList(price).indexOf(Collections.min(Arrays.asList(price)));
       System.out.println("Cheapest hotel is :- " + hotels.get(n).hotelName + " with Price :- "+ price[n]);
    }
	
}

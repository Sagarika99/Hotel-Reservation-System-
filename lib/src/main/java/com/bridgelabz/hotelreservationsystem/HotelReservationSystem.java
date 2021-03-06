package com.bridgelabz.hotelreservationsystem;

import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.regex.Pattern;

public class HotelReservationSystem {
	
	public ArrayList<Hotel> hotels = new ArrayList<Hotel>();
	Integer[] price = {0,0,0};
	Integer[] priceRewarded = {0,0,0};

	public HotelReservationSystem() {
		this.hotels = new ArrayList<Hotel>();
	}
	
	public void addHotel(Hotel hotel) {
		hotels.add(hotel);
	}
	
    public void cheapeastHotel(LocalDate startDate, LocalDate lastDate){
        ArrayList<LocalDate> dateArray = new ArrayList<LocalDate>();

        dateArray.add(startDate);
        long daysBetween = ChronoUnit.DAYS.between(startDate,lastDate);

        while (daysBetween>0){
        	dateArray.add(dateArray.get(dateArray.size()-1).plusDays(1));
            daysBetween--;
        }
        
        
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
       System.out.println("Cheapest hotel: " + hotels.get(n).hotelName + " with total rates: " +price[n]);
       
    }
	
    public void bestRatingCheapestHotel(LocalDate startDate, LocalDate lastDate) {
    	Hotel[] hotelsList = new Hotel[3];
    	ArrayList<Integer> ratingsHotel = new ArrayList<>();
        ArrayList<LocalDate> dateArray = new ArrayList<LocalDate>();

        dateArray.add(startDate);
        long daysBetween = ChronoUnit.DAYS.between(startDate,lastDate);

        while (daysBetween>0){
        	dateArray.add(dateArray.get(dateArray.size()-1).plusDays(1));
            daysBetween--;
        }
                
        for (int i=0; i<dateArray.size(); i++){
            for (int j=0; j<hotels.size(); j++) {

                if (dateArray.get(i).getDayOfWeek().equals(DayOfWeek.SATURDAY) || dateArray.get(i).getDayOfWeek().equals(DayOfWeek.SUNDAY)){
                    price[j] += hotels.get(j).rates.get(CustomerType.REGULAR).weekEndRate;
                }
                else
                    price[j] += hotels.get(j).rates.get(CustomerType.REGULAR).weekDayRate;
            }
        }
    	
    	for(int i=0; i<hotels.size(); i++) {
    		for(int j=0; j<price.length; j++) {
    			if(i != j) {
    				if(price[i].equals(price[j])) {
    					hotelsList[i] = hotels.get(i);
    				}
    			}
    		}
    	}
    	
       for(int i=0; i<hotelsList.length; i++) {
    	   if(hotelsList[i] != null) {
        	   ratingsHotel.add(hotels.get(i).hotelRating);
    	   }
       }

       int n = ratingsHotel.indexOf(Collections.max(ratingsHotel));
       System.out.println("Cheapest hotel with best Ratings for Regular: " + hotels.get(n).hotelName + " Ratings: " +hotels.get(n).hotelRating+ " with total rates: " +price[n]);
    }
    
    public void bestRatedHotel() {
        ArrayList<Integer> hotelratings = new ArrayList<>();
        for (int i=0; i<hotels.size(); i++) {
     	   hotelratings.add(hotels.get(i).hotelRating);
        }
        
        int n = hotelratings.indexOf(Collections.max(hotelratings));
        System.out.println("Best Rated hotel: " + hotels.get(n).hotelName + " with Ratings: " +hotels.get(n).hotelRating);
    }
    
    public void cheapestBestRatedRewarded(LocalDate startDate, LocalDate lastDate) {
    	Hotel[] hotelsListRewarded = new Hotel[3];
    	ArrayList<Integer> ratingsHotelRewarded = new ArrayList<>();
        ArrayList<LocalDate> dateArray = new ArrayList<LocalDate>();

        dateArray.add(startDate);
        long daysBetween = ChronoUnit.DAYS.between(startDate,lastDate);

        while (daysBetween>0){
        	dateArray.add(dateArray.get(dateArray.size()-1).plusDays(1));
            daysBetween--;
        }
                
        for (int i=0; i<dateArray.size(); i++){
            for (int j=0; j<hotels.size(); j++) {

                if (dateArray.get(i).getDayOfWeek().equals(DayOfWeek.SATURDAY) || dateArray.get(i).getDayOfWeek().equals(DayOfWeek.SUNDAY)){
                	priceRewarded[j] += hotels.get(j).rates.get(CustomerType.REWARDS).weekEndRate;
                }
                else
                	priceRewarded[j] += hotels.get(j).rates.get(CustomerType.REWARDS).weekDayRate;
            }
        }
        int temp = Arrays.asList(priceRewarded).indexOf(Collections.min(Arrays.asList(priceRewarded)));
        //System.out.println("rewared: "+temp);
    	
    	for(int i=0; i<hotels.size(); i++) {
    		for(int j=0; j<priceRewarded.length; j++) {
    			if(i != j) {   				
    				if(priceRewarded[i].equals(temp)) {
    					hotelsListRewarded[i] = hotels.get(i);
    				}
    			}
    		}
    	}
    	
       for(int i=0; i<hotelsListRewarded.length; i++) {
    	   if(hotelsListRewarded[i] != null) {
    		   ratingsHotelRewarded.add(hotels.get(i).hotelRating);
    	   }
       }
       
       if(hotelsListRewarded[0] == null && hotelsListRewarded[0] == null && hotelsListRewarded[0] == null) {
    	   int n = temp;
    	   System.out.println("Cheapest hotel with best Ratings for Rewarded: " + hotels.get(n).hotelName + " Ratings: " +hotels.get(n).hotelRating+ " with total rates: " +priceRewarded[n]);
       }
       else {
           int n = ratingsHotelRewarded.indexOf(Collections.max(ratingsHotelRewarded));
           System.out.println("Cheapest hotel with best Ratings for Rewarded: " + hotels.get(n).hotelName + " Ratings: " +hotels.get(n).hotelRating+ " with total rates: " +priceRewarded[n]);
       }       
    }
    
    public boolean validateInputDate (String date) throws HotelException{
    	try {
    		Pattern p = Pattern.compile("((19|20)\\d\\d)-(0?[1-9]|1?[012])-(0?[1-9]|[12][0-9]|3[01])");
    		return p.matcher(date).matches();
    	}
    	catch(Exception e) {
    		throw new HotelException("Invalid date");
    	}
    }
}

package com.bridgelabz.hotelreservationsystem;

public class Rates {

	private Integer weekEndRate;
	private Integer weekDayRate;
	
	public Rates(Integer weekEndRate, Integer weekDayRate) {
		this.weekEndRate = weekEndRate;
		this.weekDayRate = weekDayRate;
	}

	public Integer getWeekEndRate() {
		return weekEndRate;
	}

	public Integer getWeekDayRate() {
		return weekDayRate;
	}

}

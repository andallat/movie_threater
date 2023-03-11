package com.jpmc.theater;

import java.text.DecimalFormat;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Objects;

import com.jpmc.util.LocalDateProvider;


public class Movie {
    private static int MOVIE_CODE_SPECIAL = 1;

    private String title;
    private String description;
    private Duration runningTime;
    private double ticketPrice;
    private int specialCode;

    public Movie(String title, Duration runningTime, double ticketPrice, int specialCode) {
        this.title = title;
        this.runningTime = runningTime;
        this.ticketPrice = ticketPrice;
        this.specialCode = specialCode;
    }

    public String getTitle() {
        return title;
    }

    public Duration getRunningTime() {
        return runningTime;
    }

    public double getTicketPrice() {
        return ticketPrice;
    }

    public double calculateTicketPrice(Showing showing, String resDate) {
    	DecimalFormat df = new DecimalFormat("0.00");
    	double discount = getDiscount(showing.getSequenceOfTheDay(), showing.getStartTime().getHour(), resDate);
    	
    	//System.out.println("The original ticket price is: " + ticketPrice);
    	//System.out.println("The discount applied is: " + discount);
    	//System.out.println("final price:" + ticketPrice - discount);
    	
        return Double.valueOf(df.format(ticketPrice - discount));
    }

    private double getDiscount(int showSequence, int showHour, String resDate) {

        ArrayList<Double> discounts = new ArrayList<Double>(); 
        discounts.add(0.0);
        
        if (MOVIE_CODE_SPECIAL == specialCode) {
        	discounts.add(ticketPrice * 0.2);  // 20% discount for special movie
        }

        if (showSequence == 1) {
        	discounts.add(3.0); // $3 discount for 1st show
        } else if (showSequence == 2) {
        	discounts.add(2.0); // $2 discount for 2nd show
        } 
        
        // New Requirements
        if (showHour >= 11 && showHour <= 16) {
        	discounts.add(ticketPrice * 0.25);  // 25% discount for the shows starting between 11am and 4pm
        }
        //if (LocalDateProvider.singleton().currentDate().getDayOfMonth() == 7) {
        if (LocalDateProvider.singleton().parseDate(resDate).getDayOfMonth() == 7) {
        	discounts.add(1.0); // $1 discount on 7th of every month
        }
        
        // biggest discount wins
        return Collections.max(discounts);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Movie movie = (Movie) o;
        return Double.compare(movie.ticketPrice, ticketPrice) == 0
                && Objects.equals(title, movie.title)
                && Objects.equals(description, movie.description)
                && Objects.equals(runningTime, movie.runningTime)
                && Objects.equals(specialCode, movie.specialCode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, description, runningTime, ticketPrice, specialCode);
    }

	@Override
	public String toString() {
		return "Movie [title=" + title + ", runningTime=" + runningTime
				+ ", ticketPrice=" + ticketPrice + ", specialCode=" + specialCode + "]";
	}
    
}
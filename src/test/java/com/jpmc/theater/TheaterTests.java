package com.jpmc.theater;

import org.junit.jupiter.api.Test;

import com.jpmc.util.LocalDateProvider;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TheaterTests {
	Theater theater = new Theater(LocalDateProvider.singleton());

	@Test
    void printMovieSchedule() {
        theater.printSchedule();
    }
    
    @Test
    void printMovieScheduleInJSONFormat() {
    	theater.printScheduleJSON();
    }
    
    @Test
    void totalFeeForFourTickets() {
        Customer john = new Customer("John Doe", "id-12345");
        Reservation reservation = theater.reserve(john, 2, 4, "2023-03-07");
        System.out.println(john + " has to pay " + reservation.totalFee());
        assertEquals(reservation.totalFee(), 37.52);
    }
    
    @Test
    void totalFeeForSpecialMovieTwoTickets() {
        Customer chris = new Customer("Chris Susan", "id-23456");
        Reservation reservation = theater.reserve(chris, 1, 2, "2023-03-07");
        System.out.println(chris + " has to pay " + reservation.totalFee());
        assertEquals(reservation.totalFee(), 16.0);
    }
    
    @Test
    void totalFeeFor7thOneTicket() {
        Customer matt = new Customer("Matt Bruno", "id-65432");
        Reservation reservation = theater.reserve(matt, 7, 1, "2023-03-07");
        System.out.println(matt + " has to pay " + reservation.totalFee());
        assertEquals(reservation.totalFee(), 10.0);
    }
}

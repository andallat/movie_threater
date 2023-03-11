package com.jpmc.theater;

import org.junit.jupiter.api.Test;

import com.jpmc.util.LocalDateProvider;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MovieTests {
    @Test
    void specialMovieWithMorningShowDiscount() {
        Movie spiderMan = new Movie("Spider-Man: No Way Home", Duration.ofMinutes(90),12.5, 0);
        //Showing showing = new Showing(spiderMan, 5, LocalDateTime.of(LocalDate.now(), LocalTime.now()));
        Showing showing = new Showing(spiderMan, 5, LocalDateTime.of(LocalDate.now(), LocalTime.of(21, 10)));
        assertEquals(11.50, spiderMan.calculateTicketPrice(showing, "2023-03-07"));

        System.out.println(Duration.ofMinutes(90));
    }
}

package com.jpmc.theater;

import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MovieTests {
    @Test
    //fixed the method name to reflect test scenario
    void specialMovieWith80PercentDiscount() {
        Movie spiderMan = new Movie("Spider-Man: No Way Home", Duration.ofMinutes(90),12.5, 1);
        Showing showing = new Showing(spiderMan, 5, LocalDateTime.of(LocalDate.now(), LocalTime.now()));
        assertEquals(10, spiderMan.calculateTicketPrice(showing));

        System.out.println(Duration.ofMinutes(90));
    }
    
    // adding test case for first of the day discount
    @Test
    void firstOfTheDayDiscount() {
        Movie spiderMan = new Movie("Spider-Man: No Way Home", Duration.ofMinutes(90),13, 1);
        Showing showing = new Showing(spiderMan, 1, LocalDateTime.of(LocalDate.now(), LocalTime.now()));
        assertEquals(10, spiderMan.calculateTicketPrice(showing));

        System.out.println(Duration.ofMinutes(90));
    }
    
    // adding test case for second of the day discount
    @Test
    void secondOfTheDayDiscount() {
        Movie spiderMan = new Movie("Spider-Man: No Way Home", Duration.ofMinutes(90),13, 2);
        Showing showing = new Showing(spiderMan, 2, LocalDateTime.of(LocalDate.now(), LocalTime.now()));
        assertEquals(11, spiderMan.calculateTicketPrice(showing));

        System.out.println(Duration.ofMinutes(90));
    }
    
    // adding test case for 25% discount for shows between 11 am to 4 pm
    @Test
    void discount25Percent() {
        //test case for 25% discount
    	Movie spiderMan = new Movie("Spider-Man: No Way Home", Duration.ofMinutes(90),10, 2);
        Showing showing = new Showing(spiderMan, 3, LocalDateTime.of(LocalDate.now(), LocalTime.of(16,0)));
        assertEquals(7.5, spiderMan.calculateTicketPrice(showing));
        
        //test case for no discount
        spiderMan = new Movie("Spider-Man: No Way Home", Duration.ofMinutes(90),10, 2);
        showing = new Showing(spiderMan, 3, LocalDateTime.of(LocalDate.now(), LocalTime.of(16,30)));
        assertEquals(10, spiderMan.calculateTicketPrice(showing));

        System.out.println(Duration.ofMinutes(90));
    }
    
    //adding test case for 7th day discount
    @Test
    void day7Discount() {
    	Movie spiderMan = new Movie("Spider-Man: No Way Home", Duration.ofMinutes(90),10, 2);
        Showing showing = new Showing(spiderMan, 3, LocalDateTime.of(2023, 4, 7, 9, 0));
        assertEquals(9, spiderMan.calculateTicketPrice(showing));
    }
    
    // adding test case for no discount
    @Test
    void noDiscount() {
        Movie spiderMan = new Movie("Spider-Man: No Way Home", Duration.ofMinutes(90),13, 2);
        Showing showing = new Showing(spiderMan, 3, LocalDateTime.of(LocalDate.now(), LocalTime.now()));
        assertEquals(13, spiderMan.calculateTicketPrice(showing));

        System.out.println(Duration.ofMinutes(90));
    }

}

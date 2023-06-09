package com.jpmc.theater;

import org.junit.jupiter.api.Test;

import com.fasterxml.jackson.core.JsonProcessingException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TheaterTests {
    @Test
    void totalFeeForCustomer() {
        Theater theater = new Theater(LocalDateProvider.singleton());
        Customer john = new Customer("John Doe", "id-12345");
        Reservation reservation = theater.reserve(john, 2, 4);
        assertEquals(reservation.totalFee(), 50);
    }

    @Test
    void printMovieSchedule() throws JsonProcessingException {
        Theater theater = new Theater(LocalDateProvider.singleton());
        theater.printSchedule();
    }
}

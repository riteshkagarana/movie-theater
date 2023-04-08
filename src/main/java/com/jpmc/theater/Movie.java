package com.jpmc.theater;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Collections;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

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

    public double calculateTicketPrice(Showing showing) {
        return ticketPrice - getDiscount(showing.getSequenceOfTheDay(),showing.getStartTime());
    }

    private double getDiscount(int showSequence,LocalDateTime showStartTime) {
        double specialDiscount = 0;
        if (MOVIE_CODE_SPECIAL == specialCode) {
            specialDiscount = ticketPrice * 0.2;  // 20% discount for special movie
        }

        double sequenceDiscount = 0;
        if (showSequence == 1) {
            sequenceDiscount = 3; // $3 discount for 1st show
        } else if (showSequence == 2) {

            sequenceDiscount = 2; // $2 discount for 2nd show
        }
//        else {
//            throw new IllegalArgumentException("failed exception");
//        }
 
        double PercentDiscount25=0;
        if(showStartTime.getHour() >= 11 && showStartTime.getHour() < 16) {
        	PercentDiscount25 = ticketPrice * 0.25;
        }else if(showStartTime.getHour() == 16 && showStartTime.getMinute() == 0) {
        	PercentDiscount25 = ticketPrice * 0.25;
        }
        //todo : add this to discount calc
        double discount7th=0;
        if(showStartTime.getDayOfMonth()==7) {
        	discount7th=1;
        }
        
        Set<Double> discountSet= new HashSet<Double>();
        discountSet.add(specialDiscount);
        discountSet.add(sequenceDiscount);
        discountSet.add(PercentDiscount25);
        discountSet.add(discount7th);
        
        // biggest discount wins
        double maxDiscount = Collections.max(discountSet);
        
        return maxDiscount;
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
}
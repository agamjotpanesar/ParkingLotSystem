package com.company;

public class FareCalculator {

    double farePerMilliseconds = 1;

    public double getFare(long inTime, long outTime) {
        return farePerMilliseconds*(outTime - inTime);
    }
}

package com.company;

public class ParkingSlip {
    String vehicleId;
    long inTime;
    long outTime;
    double fare;

    ParkingSlip(String vehicleId, long inTime) {
        this.vehicleId = vehicleId;
        this.inTime = inTime;
    }

}

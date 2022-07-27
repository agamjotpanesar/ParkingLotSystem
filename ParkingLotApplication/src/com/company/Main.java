package com.company;

import static java.lang.Thread.sleep;

public class Main {

    public static void main(String[] args) throws InterruptedException {
	// write your code here
        ParkingLot parkingLot = new ParkingLot(100, "Awesome Parking Lot");
        Vehicle vehicle = new Vehicle();
        boolean slotBooked = parkingLot.hasFreeSlot(vehicle.vehicleType);
        if(!slotBooked) {
            System.out.println("No slot Available");
            return;
        }
        vehicle.receipt = parkingLot.bookSlot(vehicle.vehicleId, vehicle.vehicleType);
        System.out.println("printing SlotId " + vehicle.receipt );
        sleep(5000);
        ParkingSlip parkingSlip = parkingLot.unparkVehicle(vehicle.vehicleId, vehicle.vehicleType, vehicle.receipt);
        System.out.println("printing fare" + parkingSlip.fare );
    }
}

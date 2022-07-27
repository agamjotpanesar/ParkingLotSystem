package com.company;

import static java.lang.Thread.sleep;

public class Main {

    public static void main(String[] args) throws InterruptedException {
	// write your code here
        ParkingLot parkingLot = new ParkingLot("Awesome Parking Lot", 10, 3, 20, 10);
        Vehicle vehicle = new Bike();
        boolean isSlotBooked = parkingLot.hasFreeSlot(vehicle.vehicleType);
        if(!isSlotBooked) {
            System.out.println("No slot Available");
            return;
        }
        vehicle.receipt = parkingLot.bookSlot(vehicle.vehicleId, vehicle.vehicleType);
        System.out.println("printing SlotId " + vehicle.receipt );
        Vehicle vehicle2 = new Car();
        isSlotBooked = parkingLot.hasFreeSlot(vehicle2.vehicleType);
        if(!isSlotBooked) {
            System.out.println("No slot Available");
            return;
        }
        vehicle2.receipt = parkingLot.bookSlot(vehicle2.vehicleId, vehicle2.vehicleType);
        System.out.println("printing SlotId " + vehicle2.receipt );
        sleep(4000);
        ParkingSlip parkingSlip = parkingLot.unparkVehicle(vehicle.vehicleId, vehicle.vehicleType, vehicle.receipt);
        System.out.println("printing fare " + parkingSlip.fare );
        parkingSlip = parkingLot.unparkVehicle(vehicle2.vehicleId, vehicle2.vehicleType, vehicle2.receipt);
        System.out.println("printing fare " + parkingSlip.fare );
    }
}

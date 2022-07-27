package com.company;

import java.util.HashMap;

public class ParkingSlipManager {

    HashMap<String, ParkingSlip> parkingSlipHashMap;
    HashMap<String, FareCalculator> fareCalculatorHashMap;

    ParkingSlipManager() {
        parkingSlipHashMap = new HashMap<>();
        fareCalculatorHashMap = new HashMap<>();
        fareCalculatorHashMap.put("Car", new FareCalculator());
        fareCalculatorHashMap.put("Bike", new FareCalculator());
    }

    public void createParkingSLip(String vehicleId) {
        long inTime = System.currentTimeMillis();
        ParkingSlip newParkingSlip = new ParkingSlip(vehicleId, inTime);
        parkingSlipHashMap.put(vehicleId, newParkingSlip);
    }

    public ParkingSlip getFinalParkingSlip(String vehicleId, String vehicleType) {
        long outTime = System.currentTimeMillis();
        ParkingSlip parkingSlip = parkingSlipHashMap.get(vehicleId);
        parkingSlip.outTime = outTime;
        FareCalculator fareCalculator = fareCalculatorHashMap.get(vehicleType);
        parkingSlip.fare = fareCalculator.getFare(parkingSlip.inTime, parkingSlip.outTime);
        return parkingSlip;
    }
}

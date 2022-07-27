package com.company;

import java.util.ArrayList;
import java.util.List;

public class ParkingLot {

    String name;
    List<Slot> slots;
    int totalSlots;
    int availableSlots;
    int numberOfFloors;
    ParkingSlipManager parkingSlipManager;
    SlotManager slotManager;


    ParkingLot(int totalSlots, String name, int numberOfFloors) {
        slots = new ArrayList<>();
        this.totalSlots = totalSlots;
        this.name = name;
        availableSlots = totalSlots;
        this.numberOfFloors = numberOfFloors;
        for(int i=0;i<totalSlots;i++) {
            Slot newSlot = new Slot(i+1);
            slots.add(newSlot);
        }
        parkingSlipManager = new ParkingSlipManager();
        slotManager = new SlotManager();
    }

    public boolean hasFreeSlot( String VehicleType) {
        return availableSlots > 0;
    }

    public int bookSlot(String vehicleId, String vehicleType) {
        if(!hasFreeSlot(vehicleType)) {
            return -1;
        }
        int slotId = slotManager.assignSlot(slots);
        availableSlots--;
        parkingSlipManager.createParkingSLip(vehicleId);
        return slotId;
    }

    public ParkingSlip unparkVehicle(String vehicleId, String vehicleType, int slotId) {
        availableSlots++;
        slotManager.unparkVehicle(slotId, slots);
        return parkingSlipManager.getFinalParkingSlip(vehicleId, vehicleType);
    }
}

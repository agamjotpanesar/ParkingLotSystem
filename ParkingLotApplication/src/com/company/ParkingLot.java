package com.company;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ParkingLot {

    String name;
    HashMap<Integer, List<Slot>> slots;
    HashMap<String, Integer> availabilityOfSlots;
    int slotsPerFloor;
    int numberOfFloors;
    int carSlots;
    int bikeSlots;
    ParkingSlipManager parkingSlipManager;
    SlotManager slotManager;


    ParkingLot(String name, int slotsPerFloor, int numberOfFloors, int carSlots, int bikeSlots) {
        this.name = name;
        this.slotsPerFloor = slotsPerFloor;
        this.numberOfFloors = numberOfFloors;
        this.carSlots = carSlots;
        this.bikeSlots = bikeSlots;
        availabilityOfSlots = new HashMap<>();
        availabilityOfSlots.put("Car", carSlots);
        availabilityOfSlots.put("Bike", bikeSlots);
        slots = new HashMap<>();
        int createdCarSlots = 0;
        int createdBikeSlots = 0;
        for(int i=0;i<numberOfFloors;i++) {
            List<Slot> currentFloorSlots = new ArrayList<>();
            for(int j=0; j<slotsPerFloor; j++) {
                Slot newSlot = null;
                if(createdCarSlots != carSlots) {
                    newSlot = new CarSlotType(i * slotsPerFloor + j);
                    createdCarSlots++;
                } else if(createdBikeSlots != bikeSlots) {
                    newSlot = new BikeSlotType(i * slotsPerFloor + j);
                    createdBikeSlots++;
                }
                currentFloorSlots.add(newSlot);
            }
            slots.put(i+1, currentFloorSlots);
        }

        parkingSlipManager = new ParkingSlipManager();
        slotManager = new SlotManager(new BottomToTopAssigner());
    }
//
//    public static class Builder {
//        private String name;
//        private int slotsPerFloor;
//        private int numberOfFloors;
//        private int twoWheelerSlots;
//        private int lightFourWheelerSlots;
//        private int heavyFourWheelerSlots;
//
//        public Builder(){}
//
//        public Builder setName(String name) {
//            this.name = name;
//            return this;
//        }
//
//        public Builder setSlotsPerFloor(int slotsPerFloor) {
//            this.slotsPerFloor = slotsPerFloor;
//            return this;
//        }
//
//        public Builder setNumberOfFloors(int numberOfFloors) {
//            this.numberOfFloors = numberOfFloors;
//            return this;
//        }
//
//        public Builder setTwoWheelerSlots(int twoWheelerSlots) {
//            this.twoWheelerSlots = twoWheelerSlots;
//            return this;
//        }
//
//        public Builder setLightFourWheelerSlots(int lightFourWheelerSlots) {
//            this.lightFourWheelerSlots = lightFourWheelerSlots;
//            return this;
//        }
//
//        public Builder setHeavyFourWheelerSlots(int heavyFourWheelerSlots) {
//            this.heavyFourWheelerSlots = heavyFourWheelerSlots;
//            return this;
//        }
//
//        public ParkingLot build() {
//            return new ParkingLot(name, slotsPerFloor, numberOfFloors, twoWheelerSlots, lightFourWheelerSlots, heavyFourWheelerSlots);
//        }
//    }

    public boolean hasFreeSlot(String vehicleType) {
        return availabilityOfSlots.get(vehicleType) != null && availabilityOfSlots.get(vehicleType) > 0;
    }

    public int bookSlot(String vehicleId, String vehicleType) {
        if(!hasFreeSlot(vehicleType)) {
            return -1;
        }
        int slotId = slotManager.assignSlot(slots, vehicleType);
        availabilityOfSlots.put(vehicleType, availabilityOfSlots.get(vehicleType) - 1);
        parkingSlipManager.createParkingSLip(vehicleId);
        return slotId;
    }

    public ParkingSlip unparkVehicle(String vehicleId, String vehicleType, int slotId) {
        availabilityOfSlots.put(vehicleType, availabilityOfSlots.get(vehicleType) + 1);
        slotManager.unparkVehicle(slotId, slots, slotsPerFloor);
        return parkingSlipManager.getFinalParkingSlip(vehicleId, vehicleType);
    }
}

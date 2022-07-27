package com.company;

public class Slot {

    boolean isSlotOccupied;
    int slotId;
    String slotType;

    Slot(int slotId) {
        isSlotOccupied = false;
        this.slotId = slotId;
        slotType = "universal";
    }
}

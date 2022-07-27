package com.company;

public class Slot {

    String typeOfSlot = "universal";
    boolean isSlotOccupied;
    int slotId;

    Slot(int slotId) {
        isSlotOccupied = false;
        this.slotId = slotId;
    }
}

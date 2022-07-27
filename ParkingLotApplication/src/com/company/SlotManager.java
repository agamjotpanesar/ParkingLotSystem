package com.company;

import java.util.List;

public class SlotManager {

    public int assignSlot(List<Slot> slotList) {
        for(int i=0;i<slotList.size();i++) {
            if(!slotList.get(i).isSlotOccupied) {
                Slot toBeAssignedSlot = slotList.get(i);
                toBeAssignedSlot.isSlotOccupied = true;
                return toBeAssignedSlot.slotId;
            }
        }
        return -1;
    }

    public void unparkVehicle(int slotId, List<Slot> slotList) {
        for(int i=0;i<slotList.size();i++) {
            if(slotList.get(i).slotId == slotId) {
                Slot toBeFreed = slotList.get(i);
                toBeFreed.isSlotOccupied = false;
            }
        }
    }
}

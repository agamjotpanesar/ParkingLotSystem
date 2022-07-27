package com.company;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class SlotManager {

    SlotAssigner slotAssigner;
    SlotManager(SlotAssigner slotAssigner) {
        this.slotAssigner = slotAssigner;
    }

    public int assignSlot(HashMap<Integer, List<Slot>> slotMaps, String vehicleType) {
        return slotAssigner.assignSlot(slotMaps, vehicleType);
    }

    public void unparkVehicle(int slotId, HashMap<Integer, List<Slot>> slotMaps, int slotsPerFloor) {
        int floorId = slotId / slotsPerFloor + 1;
        List<Slot> slotList = slotMaps.get(floorId);
        for(int i=0;i<slotList.size();i++) {
            if(slotList.get(i).slotId == slotId) {
                slotList.get(i).isSlotOccupied = false;
            }
        }
    }
}

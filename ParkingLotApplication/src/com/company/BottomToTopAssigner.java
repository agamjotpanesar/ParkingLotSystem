package com.company;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BottomToTopAssigner implements SlotAssigner{

    @Override
    public int assignSlot(HashMap<Integer, List<Slot>> slotMaps, String vehicleType) {
        for(Map.Entry<Integer, List<Slot>> slotMapElement : slotMaps.entrySet()) {
            List<Slot> currentFloorSlots = slotMapElement.getValue();
            for(int i=0;i<currentFloorSlots.size();i++) {
                Slot currSlot = currentFloorSlots.get(i);
                if(!vehicleType.equals(currSlot.typeOfSlot)) {
                    continue;
                }
                if(!currSlot.isSlotOccupied) {
                    currentFloorSlots.get(i).isSlotOccupied = true;
                    return currentFloorSlots.get(i).slotId;
                }
            }
        }
        return 0;
    }
}

package com.company;

import java.util.HashMap;
import java.util.List;

public interface SlotAssigner {
    public int assignSlot(HashMap<Integer, List<Slot>> slotMaps, String vehicleType);
}

package org.gkswargam.strategy;

import org.gkswargam.models.Gate;
import org.gkswargam.models.ParkingSlot;
import org.gkswargam.models.VehicleType;

public class RandomParkingSlotStrategy implements ParkingSlotAssignmentStrategy {

    @Override
    public ParkingSlot getSlot(int parkingLotId, VehicleType vehicleType) {
        // 1. Using gateId get the parking lot
        // 2. Using the parkingLot get the empty parking slot for a given vehicle type and return it
        return null;
    }
}

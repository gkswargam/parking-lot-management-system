package org.gkswargam.strategy;

import org.gkswargam.models.Gate;
import org.gkswargam.models.ParkingSlot;
import org.gkswargam.models.VehicleType;

public interface ParkingSlotAssignmentStrategy {
    ParkingSlot getSlot(int parkingLotId, VehicleType vehicleType);
}

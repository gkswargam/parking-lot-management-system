package org.gkswargam.strategy;

public class ParkingSlotAssignmentStrategyFactory {
    public static ParkingSlotAssignmentStrategy getParkingSlotAssignmentStrategy(
            ParkingSlotAssignmentStrategyType parkingSlotAssignmentStrategyType) {
        return new RandomParkingSlotStrategy();
    }
}

package org.gkswargam.models;

import java.util.List;

public class ParkingSlot extends BaseModel {
    private int slotNUmber;
    private List<VehicleType> allowedVehicleTypes;
    private ParkingSlotStatus parkingSlotStatus;
    private ParkingFloor parkingFloor;

    public int getSlotNUmber() {
        return slotNUmber;
    }

    public void setSlotNUmber(int slotNUmber) {
        this.slotNUmber = slotNUmber;
    }

    public List<VehicleType> getAllowedVehicleTypes() {
        return allowedVehicleTypes;
    }

    public void setAllowedVehicleTypes(List<VehicleType> allowedVehicleTypes) {
        this.allowedVehicleTypes = allowedVehicleTypes;
    }

    public ParkingSlotStatus getParkingSlotStatus() {
        return parkingSlotStatus;
    }

    public void setParkingSlotStatus(ParkingSlotStatus parkingSlotStatus) {
        this.parkingSlotStatus = parkingSlotStatus;
    }

    public ParkingFloor getParkingFloor() {
        return parkingFloor;
    }

    public void setParkingFloor(ParkingFloor parkingFloor) {
        this.parkingFloor = parkingFloor;
    }
}

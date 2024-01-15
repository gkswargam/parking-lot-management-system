package org.gkswargam.models;

import org.gkswargam.strategy.ParkingSlotAssignmentStrategyType;

import java.util.List;

public class ParkingLot extends BaseModel {
    private List<Floor> floors;
    private List<Gate> entryGates;
    private List<Gate> exitGates;
    private Address address;
    private List<VehicleType> allowedVehicleTypes;
    private ParkingLotStatus parkingLotStatus;
    private ParkingSlotAssignmentStrategyType parkingSlotAssignmentStrategyType;

    public ParkingSlotAssignmentStrategyType getParkingSlotAssignmentStrategyType() {
        return parkingSlotAssignmentStrategyType;
    }

    public void setParkingSlotAssignmentStrategyType(ParkingSlotAssignmentStrategyType parkingSlotAssignmentStrategyType) {
        this.parkingSlotAssignmentStrategyType = parkingSlotAssignmentStrategyType;
    }

    public List<Floor> getFloors() {
        return floors;
    }

    public void setFloors(List<Floor> floors) {
        this.floors = floors;
    }

    public List<Gate> getEntryGates() {
        return entryGates;
    }

    public void setEntryGates(List<Gate> entryGates) {
        this.entryGates = entryGates;
    }

    public List<Gate> getExitGates() {
        return exitGates;
    }

    public void setExitGates(List<Gate> exitGates) {
        this.exitGates = exitGates;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public List<VehicleType> getAllowedVehicleTypes() {
        return allowedVehicleTypes;
    }

    public void setAllowedVehicleTypes(List<VehicleType> allowedVehicleTypes) {
        this.allowedVehicleTypes = allowedVehicleTypes;
    }

    public ParkingLotStatus getParkingLotStatus() {
        return parkingLotStatus;
    }

    public void setParkingLotStatus(ParkingLotStatus parkingLotStatus) {
        this.parkingLotStatus = parkingLotStatus;
    }
}

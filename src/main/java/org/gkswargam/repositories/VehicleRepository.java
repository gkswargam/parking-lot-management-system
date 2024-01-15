package org.gkswargam.repositories;

import org.gkswargam.models.Vehicle;

import java.util.Optional;

public class VehicleRepository {
    public Optional<Vehicle> findVehicleByNumber(String vehicleNumber) {
        return Optional.empty();
    }

    public Vehicle saveVehicle(Vehicle vehicle) {
        // save vehicle to database and get the vehicle record if successful
        return vehicle;
    }
}

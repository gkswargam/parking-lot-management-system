package org.gkswargam.services;

import org.gkswargam.models.*;
import org.gkswargam.repositories.GateRepository;
import org.gkswargam.repositories.ParkingLotRepository;
import org.gkswargam.repositories.TokenRepository;
import org.gkswargam.repositories.VehicleRepository;
import org.gkswargam.strategy.ParkingSlotAssignmentStrategy;
import org.gkswargam.strategy.ParkingSlotAssignmentStrategyFactory;

import java.util.Date;
import java.util.Optional;

public class TokenService {
    private final GateRepository gateRepository;
    private final VehicleRepository vehicleRepository;
    private final ParkingLotRepository parkingLotRepository;
    private final TokenRepository tokenRepository;

    public TokenService(GateRepository gateRepository, VehicleRepository vehicleRepository,
                        ParkingLotRepository parkingLotRepository, TokenRepository tokenRepository) {
        this.gateRepository = gateRepository;
        this.vehicleRepository = vehicleRepository;
        this.parkingLotRepository = parkingLotRepository;
        this.tokenRepository = tokenRepository;
    }

    public Token issueToken(String vehicleNumber, String vehicleOwnerName, Long gateId, VehicleType vehicleType) {
        // create token
        Token token = new Token();
        token.setEntryTime(new Date());

        Optional<Gate> gateOptional = gateRepository.findGateById(gateId);
        if(gateOptional.isEmpty()) {
            throw new RuntimeException();
        }
        Gate gate = gateOptional.get();
        token.setGeneratedAt(gate);
        token.setGeneratedBy(gate.getCurrentOperator());

        Optional<Vehicle> vehicleOptional = vehicleRepository.findVehicleByNumber(vehicleNumber);
        Vehicle savedVehicle;
        if(vehicleOptional.isEmpty()) {
            Vehicle vehicle = new Vehicle();
            vehicle.setVehicleNumber(vehicleNumber);
            vehicle.setOwnerName(vehicleOwnerName);
            vehicle.setVehicleType(vehicleType);
            savedVehicle = vehicleRepository.saveVehicle(vehicle);
        } else {
            savedVehicle = vehicleOptional.get();
        }
        token.setVehicle(savedVehicle);

        // get parking slot and then assign to token
        ParkingLot parkingLot = parkingLotRepository.findParkingLotByGateId(gateId);
        ParkingSlotAssignmentStrategy parkingSlotAssignmentStrategy = ParkingSlotAssignmentStrategyFactory
                .getParkingSlotAssignmentStrategy(parkingLot.getParkingSlotAssignmentStrategyType());
        ParkingSlot parkingSlot = parkingSlotAssignmentStrategy.getSlot(parkingLot.getId(), vehicleType);
        parkingSlot.setParkingSlotStatus(ParkingSlotStatus.OCCUPIED);
        token.setParkingSlot(parkingSlot);

        Token savedToken = tokenRepository.saveToken(token);
        savedToken.setTokenNumber("Ticket-"+ savedToken.getId());

        return savedToken;
    }
}

package com.lld.parkinglot.services;

import java.util.UUID;

import com.lld.parkinglot.exceptions.ParkingNotAvailableException;
import com.lld.parkinglot.models.EntryPoint;
import com.lld.parkinglot.models.ParkingFloor;
import com.lld.parkinglot.models.ParkingLot;
import com.lld.parkinglot.models.ParkingSlot;
import com.lld.parkinglot.models.ParkingTicket;
import com.lld.parkinglot.models.ParkingType;
import com.lld.parkinglot.models.Vehicle;

public class ParkingTicketService {
    ParkingLot parkingLot;

    public ParkingTicketService(ParkingLot parkingLot){
        this.parkingLot = ParkingLot.geParkingLot();
    }

    public ParkingSlot getAvailableSlot(ParkingType parkingType) throws ParkingNotAvailableException{
        for(ParkingFloor parkingFloor: parkingLot.getFloors()){
            for(ParkingSlot parkingSlot: parkingFloor.getSlots()){
                if(parkingSlot.getIsAvailable().equals(true) && parkingSlot.getParkingType().equals(parkingType)){
                    parkingSlot.setIsAvailable(false);
                    return parkingSlot;
                }
            }
        }
        throw new ParkingNotAvailableException(parkingType);
    }

    public ParkingTicket generateParkingTicket(EntryPoint entryPoint, Vehicle vehicle) throws ParkingNotAvailableException{
        ParkingSlot parkingSlot = getAvailableSlot(vehicle.getVehicleType());
        return ParkingTicket.builder()
                .isActive(true)
                .parkingSlot(parkingSlot)
                .entryPoint(entryPoint)
                .exitPoint(null)
                .vehicle(vehicle)
                .uuid(UUID.randomUUID())
                .build();
    }
}

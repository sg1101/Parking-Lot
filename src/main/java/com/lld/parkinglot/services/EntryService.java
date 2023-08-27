package com.lld.parkinglot.services;

import com.lld.parkinglot.exceptions.ParkingNotAvailableException;
import com.lld.parkinglot.models.EntryPoint;
import com.lld.parkinglot.models.ParkingLot;
import com.lld.parkinglot.models.ParkingTicket;
import com.lld.parkinglot.models.ParkingType;
import com.lld.parkinglot.models.Vehicle;

public class EntryService {
    private ParkingLot parkingLot;
    private ParkingTicketService parkingTicketService;
    private VehicleService vehicleService;

    public EntryService(ParkingLot parkingLot){
        this.parkingLot = parkingLot;
        this.parkingTicketService = new ParkingTicketService(parkingLot);
        this.vehicleService = new VehicleService();
    }

    private EntryPoint getEntryPoint(int id){
        for(EntryPoint entryPoint: parkingLot.getEntryPoints()){
            if(entryPoint.getId()==id)return entryPoint;
        }
        return null;
    }

    public ParkingTicket generateParkingTicket(String registerationId, ParkingType vehicleType, int entryPointId) throws ParkingNotAvailableException{
        Vehicle vehicle = vehicleService.getVehicle(registerationId, vehicleType);
        EntryPoint entryPoint = getEntryPoint(entryPointId);
        return parkingTicketService.generateParkingTicket(entryPoint, vehicle);
    }
}

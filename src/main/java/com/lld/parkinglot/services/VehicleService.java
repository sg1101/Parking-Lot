package com.lld.parkinglot.services;

import java.util.ArrayList;
import java.util.List;

import com.lld.parkinglot.models.ParkingType;
import com.lld.parkinglot.models.Vehicle;

public class VehicleService {
    private List<Vehicle> vehicles;

    public VehicleService(){
        this.vehicles = new ArrayList<>();
    }

    public Vehicle getVehicle(String registerationId, ParkingType vehicleType){
        for(Vehicle vehicle: vehicles){
            if(vehicle.getRegisterationId().equals(registerationId)){
                return vehicle;
            }
        }
        return registerVehicle(registerationId, vehicleType);
    }

    public Vehicle registerVehicle(String registerationId, ParkingType vehicleType){
        Vehicle vehicle = new Vehicle(registerationId, vehicleType);
        vehicles.add(vehicle);
        return vehicle;
    }
}

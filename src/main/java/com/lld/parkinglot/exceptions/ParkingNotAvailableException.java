package com.lld.parkinglot.exceptions;

import com.lld.parkinglot.models.ParkingType;

public class ParkingNotAvailableException extends Exception {
    public ParkingNotAvailableException(ParkingType parkingType){
        super("The parking is not available for vehicle type - " + parkingType.toString());
    }
}

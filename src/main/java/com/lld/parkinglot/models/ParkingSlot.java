package com.lld.parkinglot.models;

import lombok.Data;

@Data
public class ParkingSlot {
    ParkingType parkingType;
    Boolean isAvailable;
    ParkingSlot(ParkingType parkingType){
        this.parkingType = parkingType;
        this.isAvailable = true;
    }
}

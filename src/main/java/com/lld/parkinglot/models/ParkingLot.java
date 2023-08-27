package com.lld.parkinglot.models;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;

@Data
public class ParkingLot {

    List<ParkingFloor> floors;
    List<EntryPoint> entryPoints;
    List<ExitPoint> exitPoints;
    private static ParkingLot parkingLot;

    private ParkingLot(){
        this.floors = new ArrayList<>();
        this.entryPoints = new ArrayList<>();
        this.exitPoints = new ArrayList<>();
    }

    //SingleTon Pattern
    public static ParkingLot geParkingLot(){
        if(parkingLot==null){
            parkingLot = new ParkingLot();
        }
        return parkingLot;
    }
}

package com.lld.parkinglot.services;

import java.util.List;

import com.lld.parkinglot.models.EntryPoint;
import com.lld.parkinglot.models.ExitPoint;
import com.lld.parkinglot.models.ParkingFloor;
import com.lld.parkinglot.models.ParkingLot;

public class AdminService {
    private ParkingLot parkingLot;

    public AdminService(){
        this.parkingLot = ParkingLot.geParkingLot();
    }

    public void addEntryPoints(int id){
        EntryPoint entryPoint = new EntryPoint(id);
        this.parkingLot.getEntryPoints().add(entryPoint);
    }

    public void addExitPoints(int id){
        ExitPoint exitPoint = new ExitPoint(id);
        this.parkingLot.getExitPoints().add(exitPoint);
    }

    public void deleteEntryPoints(int id){
        List<EntryPoint> entryPoints = this.parkingLot.getEntryPoints();
        EntryPoint entryPointToRemove = null;
        for (EntryPoint entryPoint : entryPoints) {
            if (entryPoint.getId() == id) {
                entryPointToRemove = entryPoint;
                break;
            }
        }
        if (entryPointToRemove != null) {
            entryPoints.remove(entryPointToRemove);
        }
    }

    public void deleteExitPoints(int id){
        List<ExitPoint> exitPoints = this.parkingLot.getExitPoints();
        ExitPoint exitPointToRemove = null;
        for (ExitPoint exitPoint : exitPoints) {
            if (exitPoint.getId() == id) {
                exitPointToRemove = exitPoint;
                break;
            }
        }
        if (exitPointToRemove != null) {
            exitPoints.remove(exitPointToRemove);
        }
    }

    public void addFloor(int id){
        ParkingFloor parkingFloor = new ParkingFloor(id);
        parkingLot.getFloors().add(parkingFloor);
    }
}

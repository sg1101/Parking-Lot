package com.lld.parkinglot.models;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;

@Data
public class ParkingFloor {
    int floor_id;
    List<ParkingSlot> slots;
    public ParkingFloor(int floor_id){
        this.floor_id = floor_id;
        this.slots = new ArrayList<>();
    }

    public void addSlots(ParkingSlot slot){
        this.slots.add(slot);
    }
}

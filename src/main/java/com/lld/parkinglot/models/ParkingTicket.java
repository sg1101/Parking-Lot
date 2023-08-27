package com.lld.parkinglot.models;

import java.util.UUID;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ParkingTicket {
    //Builder Pattern
    private UUID uuid;
    private Vehicle vehicle;
    private ParkingSlot parkingSlot;
    private EntryPoint entryPoint;
    private ExitPoint exitPoint;
    private Boolean isActive;
}

package com.lld.parkinglot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.lld.parkinglot.models.ParkingLot;

@SpringBootApplication
public class ParkinglotApplication {

	public static void main(String[] args) {
		//SpringApplication.run(ParkinglotApplication.class, args);
		ParkingLot parkinglot = ParkingLot.geParkingLot();

	}

}

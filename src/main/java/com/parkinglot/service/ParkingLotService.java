package com.parkinglot.service;

import com.parkinglot.exception.ParkingLotException;
import com.parkinglot.model.ParkingLot;
import com.parkinglot.model.Vehicle;

public class ParkingLotService {

  private ParkingLot _parkingLot;

  public void createParkingLot() {
    if (_parkingLot != null) {
      throw new ParkingLotException("ParkingLot already exists");
    }
    _parkingLot = ParkingLot.getInstance();
  }

  public void parkVehicle(Vehicle vehicle) {
    if (!_parkingLot.isSpotAvailable(vehicle)) {
      throw new ParkingLotException("There isn't available spot");
    }
    var spot = _parkingLot.getNextAvailableSlot(vehicle);
    _parkingLot.assignVehicleToSpotAndPark(spot, vehicle);
  }

  public void freeSlot(String licenceNumber){
    _parkingLot.removeVehicle(licenceNumber);
  }

}

package com.parkinglot.model;

import com.parkinglot.exception.ParkingLotException;
import com.parkinglot.factory.SpotFactory;
import com.parkinglot.types.ParkingSpotType;
import com.parkinglot.types.VehicleType;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

public class ParkingLot {

  private static int MAX_COMPACT_SPOT_CAPACITY = 10;
  private Map<String, TreeSet<ParkingSpot>> slots;
  private Map<String, ParkingSpot> map;

  public static ParkingLot getInstance() {
    return ParkingLotHolder.INSTANCE;
  }

  private static class ParkingLotHolder {

    private static ParkingLot INSTANCE = new ParkingLot();
  }

  private ParkingLot() {
    slots = new HashMap<>();
    slots.put(ParkingSpotType.COMPACT, new TreeSet<ParkingSpot>());
    map = new HashMap<>();
  }

  public boolean isSpotAvailable(Vehicle vehicle) {
    var spotType = getSpotType(vehicle);

    if (spotType.equals(ParkingSpotType.COMPACT)) {
      return getSpotSize(spotType) < MAX_COMPACT_SPOT_CAPACITY;
    }

    return false;
  }

  private String getSpotType(Vehicle vehicle) {
    if (vehicle.getTypeString().equals(VehicleType.CAR)) {
      return ParkingSpotType.COMPACT;
    }

    throw new ParkingLotException(
        "There isn't compatible spot type for this vehicle: " + vehicle.getTypeString());
  }

  private int getSpotSize( Vehicle vehicle) {
    var spotType = getSpotType(vehicle);
    return getSpotSize(spotType);
  }

  private int getSpotSize( String spotType) {
    if (spotType.equals(ParkingSpotType.COMPACT)) {
      return slots.get(ParkingSpotType.COMPACT).size();
    }
    return -1;
  }

  public ParkingSpot getNextAvailableSlot( Vehicle vehicle) {
    int id = 1;

    if (getSpotSize(vehicle) > 0) {
      var spotType = getSpotType(vehicle);
      ParkingSpot lastSpot = slots.get(spotType).last();
      id = lastSpot.getId() + 1;
    }

    return SpotFactory.getCompactSpot(id);
  }

  public void assignVehicleToSpotAndPark( final ParkingSpot spot,
       final Vehicle vehicle) {
    spot.setVehicle(vehicle);
    slots.get(spot.getTypeString()).add(spot);
    map.put(vehicle.getLicenseNumber(), spot);
  }

  public void removeVehicle(String licenceNumber) {
    if (map.containsKey(licenceNumber)) {
      var spot = map.get(licenceNumber);
      map.remove(licenceNumber);
      slots.get(spot.getTypeString()).remove(spot);
    }
  }
}

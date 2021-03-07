package com.parkinglot.model;

import com.parkinglot.types.ParkingSpotType;

public class CompactParkingSpot extends ParkingSpot {

  public CompactParkingSpot(int id) {
    super(ParkingSpotType.COMPACT, id);
  }
}

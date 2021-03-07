package com.parkinglot.factory;

import com.parkinglot.model.ParkingSpot;
import com.parkinglot.model.CompactParkingSpot;

public class SpotFactory {
  public static ParkingSpot getCompactSpot(Integer id){
    return new CompactParkingSpot(id);
  }
}

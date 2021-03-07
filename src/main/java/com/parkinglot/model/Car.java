package com.parkinglot.model;

import com.parkinglot.types.VehicleType;

public class Car extends Vehicle {

  public Car(String licenceNumber) {
    super(licenceNumber, VehicleType.CAR);
  }

}

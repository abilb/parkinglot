package com.parkinglot.factory;

import com.parkinglot.model.Car;
import com.parkinglot.model.Vehicle;

public class VehicleFactory {
  public static Vehicle getCar(String licenceNumber){
    return new Car(licenceNumber);
  }
}

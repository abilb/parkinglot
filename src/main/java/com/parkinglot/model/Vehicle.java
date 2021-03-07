package com.parkinglot.model;

public abstract class Vehicle {

  final private String _licenseNumber;
  final private String _type;

  Vehicle(String licenceNumber, String type) {
    _licenseNumber = licenceNumber;
    _type = type;
  }

  String getLicenseNumber() {
    return _licenseNumber;
  }

  public String getTypeString() {
    return _type;
  }
}

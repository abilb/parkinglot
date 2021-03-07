package com.parkinglot.model;

public abstract class ParkingSpot implements Comparable<ParkingSpot> {

  private Vehicle _vehicle;
  private Integer _id;
  protected final String type;

  ParkingSpot(String type, int id) {
    this.type = type;
    _id = id;
  }

  public String getTypeString() {
    return type;
  }

  public Integer getId() {
    return _id;
  }

  public void setId(int id){
    _id = id;
  }

  public Vehicle getVehicle() {
    return _vehicle;
  }

  public void setVehicle(Vehicle vehicle) {
    _vehicle = vehicle;
  }

  @Override
  public int compareTo( ParkingSpot spot) {
    return _id.compareTo(spot.getId()) ;
  }
}

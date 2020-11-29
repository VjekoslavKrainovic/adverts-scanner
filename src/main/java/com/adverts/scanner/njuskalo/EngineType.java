package com.adverts.scanner.njuskalo;

public enum EngineType {

  DIESEL("602");
  private String fuelType;

  EngineType(String fuelType) {
    this.fuelType = fuelType;
  }

  public String getFuelType() {
    return fuelType;
  }

}

package com.adverts.scanner.domain.scan;

import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Scan {

  private String id;
  private String minPrice;
  private String maxPrice;
  private String minYearManufactured;
  private String maxYearManufactured;
  private EngineType engineType;
  private String minEnginePower;
  private String maxEnginePower;
  private String minMileage;
  private String maxMileage;
  private CarModel car;
  private LocalDateTime scannedAt;
  private Location location;

  public Scan(String minPrice, String maxPrice, String minYearManufactured, String maxYearManufactured,
      EngineType engineType, String minEnginePower, String maxEnginePower, String minMileage, String maxMileage,
      CarModel car, Location location) {
    this.minPrice = minPrice;
    this.maxPrice = maxPrice;
    this.minYearManufactured = minYearManufactured;
    this.maxYearManufactured = maxYearManufactured;
    this.engineType = engineType;
    this.minEnginePower = minEnginePower;
    this.maxEnginePower = maxEnginePower;
    this.minMileage = minMileage;
    this.maxMileage = maxMileage;
    this.car = car;
    this.location = location;
  }

  public void scanStarted(){
    this.scannedAt = LocalDateTime.now();
  }

}

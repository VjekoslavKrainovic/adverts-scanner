package com.adverts.scanner.domain.scan;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Scan {

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

}

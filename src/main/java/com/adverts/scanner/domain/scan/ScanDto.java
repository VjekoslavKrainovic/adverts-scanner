package com.adverts.scanner.domain.scan;

import lombok.Data;

@Data
public class ScanDto {

  private String minPrice;
  private String maxPrice;
  private String minYearManufactured;
  private String maxYearManufactured;
  private EngineTypeDto engineType;
  private String minEnginePower;
  private String maxEnginePower;
  private String minMileage;
  private String maxMileage;
  private String fullCarName;

}

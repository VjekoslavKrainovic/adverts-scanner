package com.adverts.scanner.api.rest.scan;

import com.adverts.scanner.domain.scan.CarModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ScanParameters {

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

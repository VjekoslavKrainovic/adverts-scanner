package com.adverts.scanner.api.rest.scan;

import com.adverts.scanner.domain.scan.Scan;

public class ScanDtoMapper {

  public static Scan map(ScanParameters scanParameters){
    return new Scan(scanParameters.getMinPrice(), scanParameters.getMaxPrice(), scanParameters.getMinYearManufactured(),
        scanParameters.getMaxYearManufactured(), scanParameters.getEngineType(),
        scanParameters.getMinEnginePower(), scanParameters.getMaxEnginePower(), scanParameters.getMinMileage(),
        scanParameters.getMaxMileage(), scanParameters.getCar(), scanParameters.getLocation());
  }

}

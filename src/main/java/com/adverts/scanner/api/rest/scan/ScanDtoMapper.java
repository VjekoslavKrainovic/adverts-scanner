package com.adverts.scanner.api.rest.scan;

import com.adverts.scanner.domain.scan.ScanDto;

public class ScanDtoMapper {

  public static ScanDto map(ScanParameters scanParameters){
    return new ScanDto(scanParameters.getMinPrice(), scanParameters.getMaxPrice(), scanParameters.getMinYearManufactured(),
        scanParameters.getMaxYearManufactured(), EngineTypeDtoMapper.map(scanParameters.getEngineType()),
        scanParameters.getMinEnginePower(), scanParameters.getMaxEnginePower(), scanParameters.getMinMileage(),
        scanParameters.getMaxMileage(), scanParameters.getCar());
  }

}

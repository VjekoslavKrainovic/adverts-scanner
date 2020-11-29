package com.adverts.scanner.api.rest.scan;

import com.adverts.scanner.domain.scan.EngineTypeDto;

public class EngineTypeDtoMapper {

  public static EngineTypeDto map(EngineType engineType) {
    if (engineType == EngineType.diesel) {
      return EngineTypeDto.DIESEL;
    }
    else if(engineType == EngineType.petrol) {
      return EngineTypeDto.PETROL;
    }
    else if(engineType == EngineType.hybrid) {
      return EngineTypeDto.HYBRID;
    }
    else if(engineType == EngineType.eletric) {
      return EngineTypeDto.ELETRIC;
    }
    return null;
  }

}

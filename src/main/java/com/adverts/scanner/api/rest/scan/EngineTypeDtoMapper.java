package com.adverts.scanner.api.rest.scan;

import com.adverts.scanner.domain.scan.EngineTypeDto;

public class EngineTypeDtoMapper {

  public static EngineTypeDto map(EngineType engineType) {
    if (engineType == EngineType.diesel) {
      return EngineTypeDto.diesel;
    }
    return null;
  }

}

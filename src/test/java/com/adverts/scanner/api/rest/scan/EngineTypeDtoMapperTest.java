package com.adverts.scanner.api.rest.scan;

import static org.assertj.core.api.Assertions.assertThat;

import com.adverts.scanner.domain.scan.EngineTypeDto;
import org.junit.jupiter.api.Test;

class EngineTypeDtoMapperTest {

  @Test
  void given_EngineType_Then_Map_to_Dto() {
    // prepare
    EngineType engineType = EngineType.diesel;

    // execute
    EngineTypeDto engineTypeDto = EngineTypeDtoMapper.map(engineType);

    // verify
    assertThat(engineTypeDto).isEqualTo(EngineTypeDto.diesel);
  }
}
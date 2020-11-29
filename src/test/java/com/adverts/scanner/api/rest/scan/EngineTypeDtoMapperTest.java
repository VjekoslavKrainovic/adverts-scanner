package com.adverts.scanner.api.rest.scan;

import static org.assertj.core.api.Assertions.assertThat;

import com.adverts.scanner.domain.scan.EngineTypeDto;
import org.junit.jupiter.api.Test;

class EngineTypeDtoMapperTest {

  @Test
  void given_EngineType_Then_Map_to_Diesel_Dto() {
    // prepare
    EngineType engineType = EngineType.diesel;

    // execute
    EngineTypeDto engineTypeDto = EngineTypeDtoMapper.map(engineType);

    // verify
    assertThat(engineTypeDto).isEqualTo(EngineTypeDto.DIESEL);
  }

  @Test
  void given_EngineType_Then_Map_to_Petrol_Dto() {
    // prepare
    EngineType engineType = EngineType.petrol;

    // execute
    EngineTypeDto engineTypeDto = EngineTypeDtoMapper.map(engineType);

    // verify
    assertThat(engineTypeDto).isEqualTo(EngineTypeDto.PETROL);
  }

  @Test
  void given_EngineType_Then_Map_to_Hybrid_Dto() {
    // prepare
    EngineType engineType = EngineType.hybrid;

    // execute
    EngineTypeDto engineTypeDto = EngineTypeDtoMapper.map(engineType);

    // verify
    assertThat(engineTypeDto).isEqualTo(EngineTypeDto.HYBRID);
  }

  @Test
  void given_EngineType_Then_Map_to_Eletric_Dto() {
    // prepare
    EngineType engineType = EngineType.eletric;

    // execute
    EngineTypeDto engineTypeDto = EngineTypeDtoMapper.map(engineType);

    // verify
    assertThat(engineTypeDto).isEqualTo(EngineTypeDto.ELETRIC);
  }

}
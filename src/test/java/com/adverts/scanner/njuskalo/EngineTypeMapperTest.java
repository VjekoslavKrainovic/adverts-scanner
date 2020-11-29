package com.adverts.scanner.njuskalo;

import static org.assertj.core.api.Assertions.assertThat;

import com.adverts.scanner.domain.scan.EngineTypeDto;
import org.junit.jupiter.api.Test;

class EngineTypeMapperTest {

  @Test
  void Given_Engine_Type_Petrol_Then_Map_To_NjuskaloID() {

    // prepare
    EngineTypeDto engineType = EngineTypeDto.PETROL;

    // execute
    String engineID = EngineTypeMapper.getNjuskaloId(engineType);

    // verify
    assertThat(engineID).isEqualTo("600");

  }

  @Test
  void Given_Engine_Type_Diesel_Then_Map_To_NjuskaloID() {

    // prepare
    EngineTypeDto engineType = EngineTypeDto.DIESEL;

    // execute
    String engineID = EngineTypeMapper.getNjuskaloId(engineType);

    // verify
    assertThat(engineID).isEqualTo("602");

  }

  @Test
  void Given_Engine_Type_Eletric_Then_Map_To_NjuskaloID() {

    // prepare
    EngineTypeDto engineType = EngineTypeDto.ELETRIC;

    // execute
    String engineID = EngineTypeMapper.getNjuskaloId(engineType);

    // verify
    assertThat(engineID).isEqualTo("1226");

  }

  @Test
  void Given_Engine_Type_Hybrid_Then_Map_To_NjuskaloID() {

    // prepare
    EngineTypeDto engineType = EngineTypeDto.HYBRID;

    // execute
    String engineID = EngineTypeMapper.getNjuskaloId(engineType);

    // verify
    assertThat(engineID).isEqualTo("604");

  }

}
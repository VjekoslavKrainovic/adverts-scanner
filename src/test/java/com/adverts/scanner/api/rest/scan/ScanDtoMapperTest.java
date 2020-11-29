package com.adverts.scanner.api.rest.scan;

import static org.assertj.core.api.Assertions.assertThat;

import com.adverts.scanner.domain.scan.EngineTypeDto;
import com.adverts.scanner.domain.scan.ScanDto;
import org.junit.jupiter.api.Test;

class ScanDtoMapperTest {

  @Test
  void given_ScanParameters_Then_Map() {
    // prepare
    ScanParameters scanParameters = new ScanParameters();
    scanParameters.setMinPrice("100");
    scanParameters.setMaxPrice("101");
    scanParameters.setMinYearManufactured("200");
    scanParameters.setMaxYearManufactured("201");
    scanParameters.setEngineType(EngineType.diesel);
    scanParameters.setMinEnginePower("300");
    scanParameters.setMaxEnginePower("301");
    scanParameters.setMinMileage("400");
    scanParameters.setMaxMileage("401");
    scanParameters.setFullCarName("fullCarName");

    // execute
    ScanDto scanDto = ScanDtoMapper.map(scanParameters);

    // verify
    assertThat(scanDto.getMinPrice()).isEqualTo("100");
    assertThat(scanDto.getMaxPrice()).isEqualTo("101");
    assertThat(scanDto.getMinYearManufactured()).isEqualTo("200");
    assertThat(scanDto.getMaxYearManufactured()).isEqualTo("201");
    assertThat(scanDto.getEngineType()).isEqualTo(EngineTypeDto.diesel);
    assertThat(scanDto.getMinEnginePower()).isEqualTo("300");
    assertThat(scanDto.getMaxEnginePower()).isEqualTo("301");
    assertThat(scanDto.getMinMileage()).isEqualTo("400");
    assertThat(scanDto.getMaxMileage()).isEqualTo("401");
    assertThat(scanDto.getFullCarName()).isEqualTo("fullCarName");
  }
}
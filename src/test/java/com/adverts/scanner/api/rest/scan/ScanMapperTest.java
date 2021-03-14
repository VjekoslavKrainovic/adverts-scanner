package com.adverts.scanner.api.rest.scan;

import static org.assertj.core.api.Assertions.assertThat;

import com.adverts.scanner.domain.scan.CarModel;
import com.adverts.scanner.domain.scan.EngineType;
import com.adverts.scanner.domain.scan.Scan;
import org.junit.jupiter.api.Test;

class ScanMapperTest {

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
    scanParameters.setCar(CarModel.audi_a5);

    // execute
    Scan scan = ScanDtoMapper.map(scanParameters);

    // verify
    assertThat(scan.getMinPrice()).isEqualTo("100");
    assertThat(scan.getMaxPrice()).isEqualTo("101");
    assertThat(scan.getMinYearManufactured()).isEqualTo("200");
    assertThat(scan.getMaxYearManufactured()).isEqualTo("201");
    assertThat(scan.getEngineType()).isEqualTo(EngineType.diesel);
    assertThat(scan.getMinEnginePower()).isEqualTo("300");
    assertThat(scan.getMaxEnginePower()).isEqualTo("301");
    assertThat(scan.getMinMileage()).isEqualTo("400");
    assertThat(scan.getMaxMileage()).isEqualTo("401");
    assertThat(scan.getCar()).isEqualTo(CarModel.audi_a5);
  }
}
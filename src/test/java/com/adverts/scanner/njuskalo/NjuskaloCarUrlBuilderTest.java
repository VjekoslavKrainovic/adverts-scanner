package com.adverts.scanner.njuskalo;

import static org.assertj.core.api.Assertions.assertThat;

import com.adverts.scanner.njuskalo.EngineType;
import com.adverts.scanner.njuskalo.NjuskaloCarUrl;
import com.adverts.scanner.njuskalo.NjuskaloCarUrlBuilder;
import org.junit.jupiter.api.Test;

class NjuskaloCarUrlBuilderTest {

  @Test
  void given_All_Parameters_Then_Return_Url() {

    // execute
    NjuskaloCarUrl url = new NjuskaloCarUrlBuilder("audi-a5-coupe")
        .withMinPrice("5000")
        .withMaxPrice("7000")
        .withMinYearManufactured("1989")
        .withMaxYearManufactured("2020")
        .withEngineType(EngineType.DIESEL)
        .withMinEnginePower("50")
        .withMaxEnginePower("500")
        .withMinMileage("5000")
        .withMaxMileage("500000")
        .build();

    // verify
    assertThat(url.getCarUri())
        .isEqualTo(
            "https://www.njuskalo.hr/auti/audi-a5-coupe?price%5Bmin%5D=5000&price%5Bmax%5D=7000&yearManufactured%5Bmin%5D=1989&yearManufactured%5Bmax%5D=2020&fuelTypeId=602&motorPower%5Bmin%5D=50&motorPower%5Bmax%5D=500&mileage%5Bmin%5D=5000&mileage%5Bmax%5D=500000");
  }
}
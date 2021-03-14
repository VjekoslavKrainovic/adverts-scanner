package com.adverts.scanner.njuskalo;

import com.adverts.scanner.domain.scan.CarModel;

public class NjuskaloCarUrlBuilder {

  private static final String NJUSKALO_URL = "https://www.njuskalo.hr/";
  private static final String CARS_URI = "auti/";

  private static final String MIN_PRICE_URI = "price%5Bmin%5D=";
  private static final String MAX_PRICE_URI = "price%5Bmax%5D=";
  private static final String MIN_YEAR_MANUFACTURED_URI = "yearManufactured%5Bmin%5D=";
  private static final String MAX_YEAR_MANUFACTURED_URI = "yearManufactured%5Bmax%5D=";
  private static final String MIN_MILEAGE = "mileage%5Bmin%5D=";
  private static final String MAX_MILEAGE = "mileage%5Bmax%5D=";
  private static final String ENGINE_TYPE = "fuelTypeId=";
  private static final String MIN_ENGINE_POWER = "motorPower%5Bmin%5D=";
  private static final String MAX_ENGINE_POWER = "motorPower%5Bmax%5D=";

  private StringBuilder carUriBuilder;
  private NjuskaloCarUriParser parser = new NjuskaloCarUriParser();

  public NjuskaloCarUrlBuilder(CarModel carModel) {
    String carUri = parser.getUri(carModel);
    this.carUriBuilder = new StringBuilder(NJUSKALO_URL + CARS_URI);
    this.carUriBuilder.append(carUri);
    this.carUriBuilder.append("?");
  }

  public NjuskaloCarUrl build() {
    return new NjuskaloCarUrl(carUriBuilder.toString());
  }

  public NjuskaloCarUrlBuilder withMinPrice(String minPrice) {
    addAndSignIfNotFirstUri();
    this.carUriBuilder.append(MIN_PRICE_URI);
    this.carUriBuilder.append(minPrice);

    return this;
  }

  public NjuskaloCarUrlBuilder withMaxPrice(String maxPrice) {
    addAndSignIfNotFirstUri();
    this.carUriBuilder.append(MAX_PRICE_URI);
    this.carUriBuilder.append(maxPrice);

    return this;
  }

  public NjuskaloCarUrlBuilder withMinYearManufactured(String minYearManufactured) {
    addAndSignIfNotFirstUri();
    this.carUriBuilder.append(MIN_YEAR_MANUFACTURED_URI);
    this.carUriBuilder.append(minYearManufactured);

    return this;
  }

  public NjuskaloCarUrlBuilder withMaxYearManufactured(String maxYearManufactured) {
    addAndSignIfNotFirstUri();
    this.carUriBuilder.append(MAX_YEAR_MANUFACTURED_URI);
    this.carUriBuilder.append(maxYearManufactured);

    return this;
  }

  public NjuskaloCarUrlBuilder withMinMileage(String minMileage) {
    addAndSignIfNotFirstUri();
    this.carUriBuilder.append(MIN_MILEAGE);
    this.carUriBuilder.append(minMileage);

    return this;
  }

  public NjuskaloCarUrlBuilder withMaxMileage(String maxMileage) {
    addAndSignIfNotFirstUri();
    this.carUriBuilder.append(MAX_MILEAGE);
    this.carUriBuilder.append(maxMileage);

    return this;
  }

  public NjuskaloCarUrlBuilder withEngineType(String engineType) {
    addAndSignIfNotFirstUri();
    this.carUriBuilder.append(ENGINE_TYPE);
    this.carUriBuilder.append(engineType);

    return this;
  }

  public NjuskaloCarUrlBuilder withMinEnginePower(String minEnginePower) {
    addAndSignIfNotFirstUri();
    this.carUriBuilder.append(MIN_ENGINE_POWER);
    this.carUriBuilder.append(minEnginePower);

    return this;
  }

  public NjuskaloCarUrlBuilder withMaxEnginePower(String maxEnginePower) {
    addAndSignIfNotFirstUri();
    this.carUriBuilder.append(MAX_ENGINE_POWER);
    this.carUriBuilder.append(maxEnginePower);

    return this;
  }

  private void addAndSignIfNotFirstUri() {
    final boolean isUrlEndingWithAndSign = this.carUriBuilder.toString().endsWith("?");

    if (isUrlEndingWithAndSign) {
      return;
    } else {
      this.carUriBuilder.append("&");
    }

  }

}
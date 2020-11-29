package com.adverts.scanner.access.njuskalo.car;

public enum AudiModel {

  A6_AVANT(Constant.AUDI_URI + "a6-avant"),
  A5_COUPE(Constant.AUDI_URI + "a5-coupe");

  private String model;

  AudiModel(String model) {
    this.model = model;
  }

  public String getModel() {
    return model;
  }

  public static class Constant{
    private static final String AUDI_URI = "audi-";
  }

}

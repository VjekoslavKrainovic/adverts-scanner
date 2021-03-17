package com.adverts.scanner.api.rest.scan;

import com.adverts.scanner.domain.scan.CarModel;
import com.adverts.scanner.domain.scan.EngineType;
import com.adverts.scanner.domain.scan.Scan;
import java.util.List;
import java.util.stream.Collectors;
import lombok.Data;

@Data
public class ScanResponseWrapper {

  private final List<ScanResponse> scans;

  public ScanResponseWrapper(List<ScanResponse> scans) {
    this.scans = scans;
  }

  public static ScanResponseWrapper from(List<Scan> scans) {
    List<ScanResponse> scansResponse = scans.stream().map(ScanResponse::from).collect(Collectors.toList());
    return new ScanResponseWrapper(scansResponse);
  }

  @Data
  public static class ScanResponse {

    private String id;
    private String minPrice;
    private String maxPrice;
    private String minYearManufactured;
    private String maxYearManufactured;
    private EngineType engineType;
    private String minEnginePower;
    private String maxEnginePower;
    private String minMileage;
    private String maxMileage;
    private CarModel car;

    public ScanResponse(String id, String minPrice, String maxPrice, String minYearManufactured,
        String maxYearManufactured, EngineType engineType, String minEnginePower, String maxEnginePower,
        String minMileage, String maxMileage, CarModel car) {
      this.id = id;
      this.minPrice = minPrice;
      this.maxPrice = maxPrice;
      this.minYearManufactured = minYearManufactured;
      this.maxYearManufactured = maxYearManufactured;
      this.engineType = engineType;
      this.minEnginePower = minEnginePower;
      this.maxEnginePower = maxEnginePower;
      this.minMileage = minMileage;
      this.maxMileage = maxMileage;
      this.car = car;
    }

    public static ScanResponse from(Scan scan) {
      return new ScanResponse(scan.getId(), scan.getMinPrice(), scan.getMaxPrice(), scan.getMinYearManufactured(),
          scan.getMaxYearManufactured(), scan.getEngineType(), scan.getMinEnginePower(), scan.getMaxEnginePower(),
          scan.getMinMileage(), scan.getMaxMileage(), scan.getCar());
    }

  }

}

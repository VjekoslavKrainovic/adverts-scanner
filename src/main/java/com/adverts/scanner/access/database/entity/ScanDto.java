package com.adverts.scanner.access.database.entity;

import com.adverts.scanner.domain.scan.CarModel;
import com.adverts.scanner.domain.scan.EngineType;
import com.adverts.scanner.domain.scan.Location;
import com.adverts.scanner.domain.scan.Scan;
import java.time.LocalDateTime;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "scan")
public class ScanDto {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;
  private String minPrice;
  private String maxPrice;
  private String minYearManufactured;
  private String maxYearManufactured;
  private EngineType engineType;
  private CarModel carModel;
  private String minEnginePower;
  private String maxEnginePower;
  private String minMileage;
  private String maxMileage;
  private LocalDateTime scannedAt;
  @ManyToOne(fetch = FetchType.LAZY)
  private UserDto user;
  private Location location;

  public ScanDto() {
  }

  public ScanDto(String minPrice, String maxPrice, String minYearManufactured, String maxYearManufactured,
      EngineType engineType, CarModel carModel, String minEnginePower, String maxEnginePower, String minMileage,
      String maxMileage, LocalDateTime scannedAt, UserDto user, Location location) {
    this.minPrice = minPrice;
    this.maxPrice = maxPrice;
    this.minYearManufactured = minYearManufactured;
    this.maxYearManufactured = maxYearManufactured;
    this.engineType = engineType;
    this.carModel = carModel;
    this.minEnginePower = minEnginePower;
    this.maxEnginePower = maxEnginePower;
    this.minMileage = minMileage;
    this.maxMileage = maxMileage;
    this.scannedAt = scannedAt;
    this.user = user;
    this.location = location;
  }

  public static ScanDto from(Scan scan, UserDto user) {
    return new ScanDto(scan.getMinPrice(), scan.getMaxPrice(), scan.getMinYearManufactured(),
        scan.getMaxYearManufactured(), scan.getEngineType(), scan.getCar(), scan.getMinEnginePower(),
        scan.getMaxEnginePower(), scan.getMinMileage(), scan.getMaxMileage(), scan.getScannedAt(), user, scan.getLocation());
  }

  public static Scan from(ScanDto scan){
    return new Scan(String.valueOf(scan.getId()), scan.getMinPrice(), scan.getMaxPrice(),
        scan.getMinYearManufactured(), scan.getMaxYearManufactured(), scan.getEngineType(), scan.getMinEnginePower(),
        scan.getMaxEnginePower(), scan.getMinMileage(), scan.getMaxMileage(), scan.getCarModel(),
        scan.getScannedAt(), scan.getLocation());
  }
}

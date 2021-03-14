package com.adverts.scanner.access.database.entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import lombok.Data;

@Entity
@Data
public class Scan {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;
  private int minPrice;
  private int maxPrice;
  private int minYearManufactured;
  private int maxYearManufactured;
  private String engineType;
  private int minEnginePower;
  private int maxEnginePower;
  private int minMileage;
  private int maxMileage;
  @ManyToOne(fetch = FetchType.LAZY)
  private User user;
}

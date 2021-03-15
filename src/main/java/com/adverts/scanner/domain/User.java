package com.adverts.scanner.domain;

import com.adverts.scanner.domain.scan.Scan;
import java.time.LocalDate;
import java.util.List;
import lombok.Data;

@Data
public class User {

  private String username;
  private String email;
  private String password;
  private LocalDate expireAt;
  private String phoneNumber;
  private String deviceId;
  private List<Scan> scans;

  public User(String username, String email, String password, LocalDate expireAt, String phoneNumber,
      String deviceId, List<Scan> scans) {
    this.username = username;
    this.email = email;
    this.password = password;
    this.expireAt = expireAt;
    this.phoneNumber = phoneNumber;
    this.deviceId = deviceId;
    this.scans = scans;
  }
}

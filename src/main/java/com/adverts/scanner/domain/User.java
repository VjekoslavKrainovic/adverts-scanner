package com.adverts.scanner.domain;

import com.adverts.scanner.domain.scan.Scan;
import java.util.List;
import lombok.Data;

@Data
public class User {

  private String username;
  private String email;
  private String password;
  private List<Scan> scans;

  public User(String username, String email, String password, List<Scan> scans) {
    this.username = username;
    this.email = email;
    this.password = password;
    this.scans = scans;
  }
}

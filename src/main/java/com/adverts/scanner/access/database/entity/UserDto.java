package com.adverts.scanner.access.database.entity;

import com.adverts.scanner.domain.user.User;
import com.adverts.scanner.domain.scan.Scan;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "user")
public class UserDto {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;
  private String email;
  private String password;
  private LocalDate expireAt;
  private String phoneNumber;
  private String deviceId;
  @OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
  private List<ScanDto> scans = new ArrayList<>();

  public UserDto() {
  }

  public UserDto(String email, String password, LocalDate expireAt, String phoneNumber) {
    this.email = email;
    this.password = password;
    this.expireAt = expireAt;
    this.phoneNumber = phoneNumber;
  }

  public static User from(UserDto user) {
    List<Scan> scans = user.getScans().stream().map(ScanDto::from).collect(Collectors.toList());
    return new User(user.getEmail(), user.getEmail(), user.getPassword(), user.getExpireAt(),
        user.getPhoneNumber(), user.getDeviceId(), scans);
  }

  public static UserDto from(User user){
    return new UserDto(user.getEmail(), user.getPassword(), user.getExpireAt(), user.getPhoneNumber());
  }
}

package com.adverts.scanner.api.rest.admindashboard;

import com.adverts.scanner.domain.user.User;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.time.LocalDate;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

@Data
public class CreateUserRequest {

  private String email;
  @JsonFormat(pattern = "dd.MM.yyyy")
  @DateTimeFormat(pattern = "dd.MM.yyyy")
  private LocalDate expireAt;
  private String phoneNumber;

  public User from() {
    return new User(email, email, null, expireAt, phoneNumber, null, null);
  }

}

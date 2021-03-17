package com.adverts.scanner.api.rest.admindashboard;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.time.LocalDate;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

@Data
public class UserSubscribeRequest {

  private String username;
  @JsonFormat(pattern = "dd.MM.yyyy")
  @DateTimeFormat(pattern = "dd.MM.yyyy")
  private LocalDate expireAt;

}

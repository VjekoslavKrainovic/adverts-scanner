package com.adverts.scanner.api.rest.user;

import com.adverts.scanner.domain.user.User;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;
import lombok.Data;

@Data
public class UserResponseWrapper {

  private final List<UserResponse> users;

  public UserResponseWrapper(List<UserResponse> users) {
    this.users = users;
  }

  public static UserResponseWrapper from(List<User> users) {
    List<UserResponse> userResponses = users.stream().map(UserResponse::from).collect(Collectors.toList());
    return new UserResponseWrapper(userResponses);
  }

  @Data
  public static class UserResponse{
    private String username;
    private String email;
    private LocalDate expireAt;
    private String phoneNumber;
    private String deviceId;

    public UserResponse(String username, String email, LocalDate expireAt, String phoneNumber, String deviceId) {
      this.username = username;
      this.email = email;
      this.expireAt = expireAt;
      this.phoneNumber = phoneNumber;
      this.deviceId = deviceId;
    }

    public static UserResponse from(User user){
      return new UserResponse(user.getUsername(), user.getEmail(), user.getExpireAt(),
          user.getPhoneNumber(), user.getDeviceId());
    }

  }

}

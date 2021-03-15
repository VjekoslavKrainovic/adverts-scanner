package com.adverts.scanner.domain.user;

import java.time.LocalDate;

public interface UserManagmentService {

  void createUser(User user);
  void subscribeUser(String username, LocalDate expireAt);
}

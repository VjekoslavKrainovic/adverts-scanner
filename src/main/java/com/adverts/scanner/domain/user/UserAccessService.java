package com.adverts.scanner.domain.user;

import java.time.LocalDate;

public interface UserAccessService {

  String getEmailFromScanId(String scanId);
  void createUser(User user);
  void subscribeUser(String username, LocalDate expireAt);
}

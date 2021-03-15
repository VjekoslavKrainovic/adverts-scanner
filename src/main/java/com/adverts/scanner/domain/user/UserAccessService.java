package com.adverts.scanner.domain.user;

public interface UserAccessService {

  String getEmailFromScanId(String scanId);
  void createUser(User user);
}

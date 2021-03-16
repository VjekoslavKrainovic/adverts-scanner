package com.adverts.scanner.domain.user;

import java.time.LocalDate;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface UserAccessService {

  String getEmailFromScanId(String scanId);

  void createUser(User user);

  void subscribeUser(String username, LocalDate expireAt);

  Page<User> getUsers(Pageable pageable);
}

package com.adverts.scanner.domain.user;

import com.adverts.scanner.Util;
import com.adverts.scanner.domain.notification.NotificationService;
import java.time.LocalDate;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class UserManagmentServiceImpl implements UserManagmentService {

  private final NotificationService notificationService;
  private final UserAccessService userAccessService;

  public UserManagmentServiceImpl(NotificationService notificationService,
      UserAccessService userAccessService) {
    this.notificationService = notificationService;
    this.userAccessService = userAccessService;
  }

  @Override
  public void createUser(User user) {
    log.info("createUser() START");
    String password = Util.getRandomString(10);
    user.setPassword(Util.encrypt(password));

    userAccessService.createUser(user);
    notificationService.userCreated(user.getEmail(), password);
    log.info("createUser() END");
  }

  @Override
  public void subscribeUser(String username, LocalDate expireAt) {
    log.info("subscribeUser() START");
    userAccessService.subscribeUser(username, expireAt);
    log.info("subscribeUser() END");
  }
}

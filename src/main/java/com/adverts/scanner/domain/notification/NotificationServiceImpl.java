package com.adverts.scanner.domain.notification;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class NotificationServiceImpl implements NotificationService {

  @Override
  public void scanFound(String username, String advertsUrl) {
    log.info("scanFound() START");

    log.info("scanFound() END");
  }

  @Override
  public void userCreated(String email, String password) {
    log.info("userCreated() START");

    log.info("userCreated() END");
  }
}

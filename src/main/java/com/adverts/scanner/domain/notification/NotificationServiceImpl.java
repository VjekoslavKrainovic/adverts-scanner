package com.adverts.scanner.domain.notification;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class NotificationServiceImpl implements NotificationService {

  @Override
  public void notify(String username, String advertsUrl) {
    log.info("notify() START");

    log.info("notify() END");
  }
}

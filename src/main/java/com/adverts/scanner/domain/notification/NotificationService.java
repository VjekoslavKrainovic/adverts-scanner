package com.adverts.scanner.domain.notification;

public interface NotificationService {
 void scanFound(String username, String advertsUrl);
 void userCreated(String email, String password);
}

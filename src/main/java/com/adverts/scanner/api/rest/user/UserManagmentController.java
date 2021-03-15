package com.adverts.scanner.api.rest.user;

import com.adverts.scanner.domain.user.UserManagmentService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/")
public class UserManagmentController {

  private final UserManagmentService userManagmentService;

  public UserManagmentController(UserManagmentService userManagmentService) {
    this.userManagmentService = userManagmentService;
  }

  @PostMapping("v1/user/create")
  public void createUser(@RequestBody CreateUserRequest createUserRequest) {
    userManagmentService.createUser(createUserRequest.from());
  }

  @PostMapping("v1/user/subscribe")
  public void subscribeUser(@RequestBody UserSubscribeRequest userSubscribeRequest) {
    userManagmentService.subscribeUser(userSubscribeRequest.getUsername(), userSubscribeRequest.getExpireAt());
  }

}

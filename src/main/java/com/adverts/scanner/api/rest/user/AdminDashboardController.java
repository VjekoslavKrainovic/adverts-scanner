package com.adverts.scanner.api.rest.user;

import com.adverts.scanner.domain.user.User;
import com.adverts.scanner.domain.user.UserManagmentService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/")
public class AdminDashboardController {

  private final UserManagmentService userManagmentService;

  public AdminDashboardController(UserManagmentService userManagmentService) {
    this.userManagmentService = userManagmentService;
  }

  @PostMapping("v1/admin/user")
  public void createUser(@RequestBody CreateUserRequest createUserRequest) {
    userManagmentService.createUser(createUserRequest.from());
  }

  @PostMapping("v1/admin/user/subscribe")
  public void subscribeUser(@RequestBody UserSubscribeRequest userSubscribeRequest) {
    userManagmentService.subscribeUser(userSubscribeRequest.getUsername(), userSubscribeRequest.getExpireAt());
  }

  @GetMapping("v1/admin/user")
  public ResponseEntity<UserResponseWrapper> getUsers(Pageable pageable) {
    Page<User> users = userManagmentService.getUsers(pageable);

    UserResponseWrapper userRespons = UserResponseWrapper.from(users.getContent());

    HttpHeaders responseHeaders = new HttpHeaders();
    responseHeaders.set("totalElements", String.valueOf(users.getTotalElements()));
    responseHeaders.set("totalPages", String.valueOf(users.getTotalPages()));
    responseHeaders.set("hasNext", String.valueOf(users.hasNext()));
    responseHeaders.set("hasPrevious", String.valueOf(users.hasPrevious()));

    return ResponseEntity.ok()
        .headers(responseHeaders)
        .body(userRespons);
  }
}

package com.adverts.scanner.access.database;

import com.adverts.scanner.access.database.entity.UserDto;
import com.adverts.scanner.access.database.repository.UserRepository;
import com.adverts.scanner.domain.user.User;
import com.adverts.scanner.domain.user.UserAccessService;
import java.time.LocalDate;
import org.springframework.stereotype.Service;

@Service
public class UserAccessServiceImpl implements UserAccessService {

  private final UserRepository userRepository;

  public UserAccessServiceImpl(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  @Override
  public String getEmailFromScanId(String scanId) {
    UserDto user = userRepository.findByScansId(Integer.parseInt(scanId))
        .orElseThrow(IllegalArgumentException::new);
    return user.getEmail();
  }

  @Override
  public void createUser(User user) {
    userRepository.findByEmail(user.getEmail()).ifPresent(u -> {
      throw new IllegalArgumentException("User with email: "+  u.getEmail() + " already exist");
    });

    userRepository.save(UserDto.from(user));

  }

  @Override
  public void subscribeUser(String username, LocalDate expireAt) {
    UserDto user = userRepository.findByEmail(username)
        .orElseThrow(IllegalArgumentException::new);
    user.setExpireAt(expireAt);
    userRepository.save(user);
  }


}

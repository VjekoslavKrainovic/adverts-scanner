package com.adverts.scanner.access.database;

import com.adverts.scanner.access.database.entity.UserDto;
import com.adverts.scanner.access.database.repository.UserRepository;
import com.adverts.scanner.domain.UserAccessService;
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
}

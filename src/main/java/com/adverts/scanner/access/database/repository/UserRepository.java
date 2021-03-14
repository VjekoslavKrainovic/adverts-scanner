package com.adverts.scanner.access.database.repository;

import com.adverts.scanner.access.database.entity.UserDto;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserDto, Integer> {

  Optional<UserDto> findByEmail(String email);
  Optional<UserDto> findByScansId(int id);

}

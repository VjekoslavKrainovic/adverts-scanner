package com.adverts.scanner.access.database.repository;

import com.adverts.scanner.access.database.entity.ScanDto;
import java.time.LocalDateTime;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ScanRepository extends JpaRepository<ScanDto, Integer> {

  List<ScanDto> findByUserEmail(String email);

  List<ScanDto> findByScannedAtLessThanEqual(LocalDateTime scannedAt);
}
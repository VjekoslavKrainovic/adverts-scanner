package com.adverts.scanner.access.database;

import com.adverts.scanner.access.database.entity.ScanDto;
import com.adverts.scanner.access.database.entity.UserDto;
import com.adverts.scanner.access.database.repository.ScanRepository;
import com.adverts.scanner.access.database.repository.UserRepository;
import com.adverts.scanner.domain.scan.Scan;
import com.adverts.scanner.domain.scan.ScanAccessService;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ScanAccessServiceImpl implements ScanAccessService {

  private final ScanRepository scanRepository;
  private final UserRepository userRepository;

  public ScanAccessServiceImpl(ScanRepository scanRepository,
      UserRepository userRepository) {
    this.scanRepository = scanRepository;
    this.userRepository = userRepository;
  }

  public void save(Scan scan, String username) {
    UserDto user = userRepository.findByEmail(username).orElseThrow(IllegalArgumentException::new);

    ScanDto scanDto = ScanDto.from(scan, user);

    scanRepository.save(scanDto);

  }

  @Override
  public List<Scan> getNonScanned() {
    List<ScanDto> scans = scanRepository.findByScannedAtLessThanEqual(LocalDateTime.now());
    return scans.stream().map(ScanDto::from).collect(Collectors.toList());
  }

  @Override
  public void updateScanTime(Scan scan) {
    ScanDto scanDto = scanRepository.findById(Integer.parseInt(scan.getId()))
        .orElseThrow(IllegalArgumentException::new);
    scanDto.setScannedAt(scan.getScannedAt());
    scanRepository.save(scanDto);
  }

  @Override
  public Page<Scan> getByUsername(String username, Pageable pageable) {
    Page<ScanDto> scans = scanRepository.findByUserEmail(username, pageable);
    return scans.map(ScanDto::from);
  }

  @Override
  public void deleteScanByIdAndUsername(String username, String id) {
    Optional<ScanDto> scan = scanRepository.findById(Integer.parseInt(id));
    scan.ifPresent(scanDto -> {
      if (scanDto.getUser().getEmail().equals(username)) {
        scanRepository.deleteById(Integer.parseInt(id));
      }
    });
  }

}

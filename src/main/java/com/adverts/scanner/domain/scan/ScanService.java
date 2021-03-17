package com.adverts.scanner.domain.scan;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ScanService {

  String createScan(Scan scan, String username);

  void startScan();

  Page<Scan> getScansByUsername(String username, Pageable pageable);

  void deleteScanByUser(String username, String id);
}

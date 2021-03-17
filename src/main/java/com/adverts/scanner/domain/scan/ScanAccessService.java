package com.adverts.scanner.domain.scan;

import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ScanAccessService {

  void save(Scan scan, String username);

  List<Scan> getNonScanned();

  void updateScanTime(Scan scan);

  Page<Scan> getByUsername(String username, Pageable pageable);

  void deleteScanByIdAndUsername(String username, String id);

}

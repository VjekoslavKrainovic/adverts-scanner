package com.adverts.scanner.domain.scan;

import java.util.List;

public interface ScanAccessService {

  void save(Scan scan, String username);

  List<Scan> getNonScanned();

  void updateScanTime(Scan scan);
}

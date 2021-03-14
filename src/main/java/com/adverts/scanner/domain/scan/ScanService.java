package com.adverts.scanner.domain.scan;

public interface ScanService {

  String createScan(Scan scan, String username);

  void startScan();

}

package com.adverts.scanner.domain.scan;

import java.util.Optional;
import org.springframework.stereotype.Service;

@Service
public class ScanServiceImpl implements ScanService {

  private final ShopScanner shopScanner;

  public ScanServiceImpl(ShopScanner shopScanner) {
    this.shopScanner = shopScanner;
  }

  @Override
  public String createScan(ScanDto scan) {
    Optional<String> productUrl = shopScanner.scanForProducts(scan);
    return productUrl.orElse(null);
  }
}

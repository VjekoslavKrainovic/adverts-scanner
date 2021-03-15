package com.adverts.scanner.domain.scan;

import com.adverts.scanner.domain.notification.NotificationService;
import com.adverts.scanner.domain.user.UserAccessService;
import java.util.List;
import java.util.Optional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class ScanServiceImpl implements ScanService {

  private final ShopScanner shopScanner;
  private final ScanAccessService scanAccessService;
  private final NotificationService notificationService;
  private final UserAccessService userAccessService;

  public ScanServiceImpl(ShopScanner shopScanner, ScanAccessService scanAccessService,
      NotificationService notificationService, UserAccessService userAccessService) {
    this.shopScanner = shopScanner;
    this.scanAccessService = scanAccessService;
    this.notificationService = notificationService;
    this.userAccessService = userAccessService;
  }

  @Override
  public String createScan(Scan scan, String username) {
    log.info("createScan() START");
    scan.scanStarted();
    Optional<String> productUrl = shopScanner.scanForProducts(scan);
    scanAccessService.save(scan, username);
    log.info("createScan() END");
    return productUrl.orElse(null);
  }

  @Override
  public void startScan() {
    log.info("startScan() START");
    List<Scan> scans = scanAccessService.getNonScanned();

    scans.forEach(scan -> {
      Optional<String> scanUrl = shopScanner.scanForProducts(scan);

      scanUrl.ifPresent(s -> {
        log.info("Scan found for scanId: {}", scan.getId());
            notificationService.scanFound(userAccessService.getEmailFromScanId(scan.getId()), s);
          }
      );
      scanAccessService.updateScanTime(scan);
    });
    log.info("startScan() END");
  }


}

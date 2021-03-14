package com.adverts.scanner.scheduled;

import com.adverts.scanner.domain.scan.ScanService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class ScanJob {

  private final ScanService scanService;

  public ScanJob(ScanService scanService) {
    this.scanService = scanService;
  }

  @Scheduled(fixedDelayString = "${app.cron.advert-scan-in-miliseconds}", zone = "Europe/Budapest")
  public void scanAdverts(){
    log.info("scanAdverts() START");
    scanService.startScan();
    log.info("scanAdverts() END");

  }

}

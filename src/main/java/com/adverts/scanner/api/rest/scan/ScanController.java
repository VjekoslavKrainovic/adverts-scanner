package com.adverts.scanner.api.rest.scan;

import com.adverts.scanner.domain.scan.Scan;
import com.adverts.scanner.domain.scan.ScanService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/")
public class ScanController {

  private final ScanService scanService;

  public ScanController(ScanService scanService) {
    this.scanService = scanService;
  }

  @PostMapping("v1/scan/create")
  public ScanResponse createScan(@RequestBody ScanParameters scanParameters){
    Scan scan = ScanDtoMapper.map(scanParameters);
    String advertShopUrl = scanService.createScan(scan, "vjeko@email.com");
    return new ScanResponse(advertShopUrl);
  }

}

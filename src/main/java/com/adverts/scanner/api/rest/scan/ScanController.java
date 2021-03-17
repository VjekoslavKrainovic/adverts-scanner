package com.adverts.scanner.api.rest.scan;

import com.adverts.scanner.Util;
import com.adverts.scanner.domain.scan.Scan;
import com.adverts.scanner.domain.scan.ScanService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

  // TODO: add Principal
  @PostMapping("v1/scan")
  public ScanUrlResponse createScan(@RequestBody ScanParameters scanParameters) {
    Scan scan = ScanDtoMapper.map(scanParameters);
    String advertShopUrl = scanService.createScan(scan, "vjeko@email.com");
    return new ScanUrlResponse(advertShopUrl);
  }

  // TODO: add Principal
  @GetMapping("v1/scan")
  public ResponseEntity<ScanResponseWrapper> getScans(Pageable pageable) {
    Page<Scan> scans = scanService.getScansByUsername("vjeko@email.com", pageable);
    ScanResponseWrapper scanResponseWrapper = ScanResponseWrapper.from(scans.getContent());

    return ResponseEntity.ok()
        .headers(Util.getHeaderWithPaginationsData(scans))
        .body(scanResponseWrapper);
  }

  // TODO: add Principal
  @DeleteMapping("v1/scan/{id}")
  public void deleteScan(@PathVariable String id) {
    scanService.deleteScanByUser("vjeko@email.com", id);
  }

}

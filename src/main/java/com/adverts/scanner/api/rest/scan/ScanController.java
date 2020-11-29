package com.adverts.scanner.api.rest.scan;

import com.adverts.scanner.domain.scan.ScanService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/")
public class ScanController {

  private ScanService scanService;

  public ScanController(ScanService scanService) {
    this.scanService = scanService;
  }

  @PostMapping("v1/scan/create")
  public String createScan(@RequestBody ScanParameters scanParameters){
    return scanService.createScan(ScanDtoMapper.map(scanParameters));
  }

}

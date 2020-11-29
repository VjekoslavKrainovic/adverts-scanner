package com.adverts.scanner.domain.scan;

import com.adverts.scanner.domain.downloaderhtml.HtmlDownloader;
import org.springframework.stereotype.Service;

@Service
public class ScanServiceImpl implements ScanService {

  private final HtmlDownloader htmlDownloader;

  public ScanServiceImpl(HtmlDownloader htmlDownloader) {
    this.htmlDownloader = htmlDownloader;
  }

  @Override
  public void createScan(ScanDto scan) {

  }
}

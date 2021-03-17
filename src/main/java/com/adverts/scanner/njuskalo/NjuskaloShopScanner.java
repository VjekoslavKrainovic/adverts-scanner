package com.adverts.scanner.njuskalo;

import com.adverts.scanner.domain.downloaderhtml.HtmlDownloader;
import com.adverts.scanner.domain.scan.Scan;
import com.adverts.scanner.domain.scan.ShopScanner;
import java.net.URI;
import java.util.Optional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class NjuskaloShopScanner implements ShopScanner {

  private final HtmlDownloader htmlDownloader;


  public NjuskaloShopScanner(HtmlDownloader htmlDownloader) {
    this.htmlDownloader = htmlDownloader;
  }

  @Override
  public Optional<String> scanForProducts(Scan scan) {

    NjuskaloCarUrl url = new NjuskaloCarUrlBuilder(scan.getCar())
        .withMinPrice(scan.getMinPrice())
        .withMaxPrice(scan.getMaxPrice())
        .withMinYearManufactured(scan.getMinYearManufactured())
        .withMaxYearManufactured(scan.getMaxYearManufactured())
        .withEngineType(scan.getEngineType())
        .withMinEnginePower(scan.getMinEnginePower())
        .withMaxEnginePower(scan.getMaxEnginePower())
        .withMinMileage(scan.getMinMileage())
        .withMaxMileage(scan.getMaxMileage())
        .withLocation(scan.getLocation())
        .build();

    Optional<String> htmlBody = htmlDownloader.execute(URI.create(url.getCarUri()));

    NjuskaloProductsScanner productsScanner = new NjuskaloProductsScanner(htmlBody.get());

    log.info("Njuskalo scan url: {}", url.getCarUri());

    if (productsScanner.isProductsExist()) {
      return Optional.of(url.getCarUri());
    }

    return Optional.empty();
  }
}

package com.adverts.scanner.njuskalo;

import com.adverts.scanner.domain.downloaderhtml.HtmlDownloader;
import com.adverts.scanner.domain.scan.ScanDto;
import com.adverts.scanner.domain.scan.ShopScanner;
import java.net.URI;
import java.util.Optional;
import org.springframework.stereotype.Service;

@Service
public class NjuskaloShopScanner implements ShopScanner {

  private final HtmlDownloader htmlDownloader;

  public NjuskaloShopScanner(HtmlDownloader htmlDownloader) {
    this.htmlDownloader = htmlDownloader;
  }

  @Override
  public boolean scanForProducts(ScanDto scanDto) {

    NjuskaloCarUrl url = new NjuskaloCarUrlBuilder(scanDto.getFullCarName())
        .withMinPrice(scanDto.getMinPrice())
        .withMaxPrice(scanDto.getMaxPrice())
        .withMinYearManufactured(scanDto.getMinYearManufactured())
        .withMaxYearManufactured(scanDto.getMaxYearManufactured())
        .withEngineType(EngineType.DIESEL) // TODO: fix this hard coded
        .withMinEnginePower(scanDto.getMinEnginePower())
        .withMaxEnginePower(scanDto.getMaxEnginePower())
        .withMinMileage(scanDto.getMinMileage())
        .withMaxMileage(scanDto.getMaxMileage())
        .build();

    Optional<String> htmlBody = htmlDownloader.execute(URI.create(url.getCarUri()));

    NjuskaloProductsScanner productsScanner = new NjuskaloProductsScanner(htmlBody.get());

    return productsScanner.isProductsExist();
  }
}

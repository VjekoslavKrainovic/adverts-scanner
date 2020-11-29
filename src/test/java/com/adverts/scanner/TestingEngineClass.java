package com.adverts.scanner;

import static org.assertj.core.api.Assertions.assertThat;

import com.adverts.scanner.access.njuskalo.HtmlDownloader;
import com.adverts.scanner.access.njuskalo.HtmlDownloaderImpl;
import com.adverts.scanner.access.njuskalo.NjuskaloCarUrl;
import com.adverts.scanner.access.njuskalo.NjuskaloProductsScanner;
import com.adverts.scanner.access.njuskalo.ProductsScanner;
import com.adverts.scanner.access.njuskalo.car.AudiModel;
import com.adverts.scanner.access.njuskalo.car.NjuskaloCarUrlBuilder;
import java.net.URI;
import java.util.Optional;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestingEngineClass {

  private ProductsScanner productsScanner;

  private HtmlDownloader htmlDownloader;

  @BeforeEach
  void setUp() {
    htmlDownloader = new HtmlDownloaderImpl();
  }

  @Test
  void given_URL_Then_Check_If_Products_Exists() {
    // prepare
    NjuskaloCarUrl url = new NjuskaloCarUrlBuilder(AudiModel.A5_COUPE.getModel())
        .withMinPrice("5000")
        .withMaxPrice("7000")
        .withMinYearManufactured("1989")
        .withMaxYearManufactured("2020")
        .build();

    URI uri = URI.create(url.getCarUri());

    Optional<String> htmlBody = htmlDownloader.execute(uri);

    // execute
    productsScanner = new NjuskaloProductsScanner(htmlBody.get());
    boolean productsExist = productsScanner.isProductsExist();

    // verify
    assertThat(productsExist).isFalse();
  }
}

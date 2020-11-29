package component;

import static org.assertj.core.api.Assertions.assertThat;

import com.adverts.scanner.domain.downloaderhtml.HtmlDownloader;
import com.adverts.scanner.domain.downloaderhtml.HtmlDownloaderImpl;
import com.adverts.scanner.njuskalo.NjuskaloCarUrl;
import com.adverts.scanner.njuskalo.NjuskaloCarUrlBuilder;
import com.adverts.scanner.njuskalo.NjuskaloProductsScanner;
import java.net.URI;
import java.util.Optional;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestingEngineClass {

  private NjuskaloProductsScanner productsScanner;

  private HtmlDownloader htmlDownloader;

  @BeforeEach
  void setUp() {
    htmlDownloader = new HtmlDownloaderImpl();
  }

  @Test
  void given_URL_Then_Check_If_Products_Exists() {
    // prepare
    NjuskaloCarUrl url = new NjuskaloCarUrlBuilder("audi-a5-coupe")
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

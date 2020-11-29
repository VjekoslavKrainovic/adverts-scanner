package component;

import static org.assertj.core.api.Assertions.assertThat;

import com.adverts.scanner.domain.downloaderhtml.HtmlDownloader;
import com.adverts.scanner.domain.downloaderhtml.HtmlDownloaderImpl;
import com.adverts.scanner.njuskalo.NjuskaloProductsScanner;
import java.net.URI;
import java.util.Optional;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class NjuskaloProductsScannerTest {

  private NjuskaloProductsScanner productsScanner;

  private HtmlDownloader htmlDownloader;

  @BeforeEach
  void setUp() {
    htmlDownloader = new HtmlDownloaderImpl();
  }

  @Test
  void given_HtmlBody_Then_Parse_All_Products() {
    // prepare
    Optional<String> htmlBody = htmlDownloader.execute(URI.create("https://www.njuskalo.hr/auti/audi-a5-coupe"));

    // execute
    productsScanner = new NjuskaloProductsScanner(htmlBody.get());
    boolean productsExist = productsScanner.isProductsExist();

    // verify
    assertThat(productsExist).isTrue();
  }
}
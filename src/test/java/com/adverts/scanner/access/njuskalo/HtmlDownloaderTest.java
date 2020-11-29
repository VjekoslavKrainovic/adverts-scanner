package com.adverts.scanner.access.njuskalo;

import static org.assertj.core.api.Assertions.as;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.net.URI;
import java.util.Optional;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class HtmlDownloaderTest {

  private HtmlDownloader htmlDownloader;

  @BeforeEach
  void setUp() {
    htmlDownloader = new HtmlDownloaderImpl();
  }

  @Test
  void given_URI_Then_Download_Html() {
    // execute
    Optional<String> htmlBody = htmlDownloader.execute(URI.create("https://www.njuskalo.hr/auti/audi-a5-coupe"));

    // verify
    assertThat(htmlBody.isPresent()).isTrue();
    assertThat(htmlBody.get()).contains("</div>");
  }
}
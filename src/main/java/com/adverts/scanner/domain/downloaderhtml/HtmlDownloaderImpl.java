package com.adverts.scanner.domain.downloaderhtml;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.Optional;
import org.springframework.stereotype.Service;

@Service
public class HtmlDownloaderImpl implements HtmlDownloader {

  public Optional<String> execute(URI url) {
    try {
      HttpClient client = HttpClient.newHttpClient();
      HttpRequest request = HttpRequest.newBuilder()
          .uri(url)
          .build();

      HttpResponse<String> response =
          client.send(request, BodyHandlers.ofString());

      return Optional.of(response.body());

    } catch (Exception e) {
      e.printStackTrace();
      return Optional.empty();
    }
  }

}

package com.adverts.scanner.domain.downloaderhtml;

import java.net.URI;
import java.util.Optional;

public interface HtmlDownloader {

  Optional<String> execute(URI url);

}

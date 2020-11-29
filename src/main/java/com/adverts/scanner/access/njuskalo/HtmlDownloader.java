package com.adverts.scanner.access.njuskalo;

import java.net.URI;
import java.util.Optional;

public interface HtmlDownloader {

  Optional<String> execute(URI url);

}

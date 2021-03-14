package com.adverts.scanner.domain.scan;

import java.util.Optional;

public interface ShopScanner {

  Optional<String> scanForProducts(Scan scan);

}

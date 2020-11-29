package com.adverts.scanner.njuskalo;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class NjuskaloProductsScanner {

  private String htmlBody;
  private Document htmlDocument;

  public NjuskaloProductsScanner(String htmlBody) {
    this.htmlBody = htmlBody;
    this.htmlDocument = Jsoup.parse(htmlBody);
  }

  public boolean isProductsExist() {

    Elements allProducts = htmlDocument.select("ul.EntityList-items");

    if (allProducts.size() > 2) {
      return true;
    }

    return false;
  }
}

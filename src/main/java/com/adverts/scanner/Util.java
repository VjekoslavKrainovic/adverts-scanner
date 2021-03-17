package com.adverts.scanner;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpHeaders;

public class Util {

  public static String getRandomString(int length) {
    return RandomStringUtils.randomAlphabetic(10);
  }

  // TODO: kad impl spring security dodaj encrypt
  public static String encrypt(String string) {
    return string;
  }

  public static HttpHeaders getHeaderWithPaginationsData(Page<?> scans) {
    HttpHeaders responseHeaders = new HttpHeaders();
    responseHeaders.set("totalElements", String.valueOf(scans.getTotalElements()));
    responseHeaders.set("totalPages", String.valueOf(scans.getTotalPages()));
    responseHeaders.set("hasNext", String.valueOf(scans.hasNext()));
    responseHeaders.set("hasPrevious", String.valueOf(scans.hasPrevious()));
    return responseHeaders;
  }

}

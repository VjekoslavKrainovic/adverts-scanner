package com.adverts.scanner;

import org.apache.commons.lang3.RandomStringUtils;

public class Util {

  public static String getRandomString(int length){
    return RandomStringUtils.randomAlphabetic(10);
  }

  // TODO: kad impl spring security dodaj encrypt
  public static String encrypt(String string){
    return string;
  }

}

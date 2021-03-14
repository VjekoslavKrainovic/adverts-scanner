package com.adverts.scanner.njuskalo;


import com.adverts.scanner.domain.scan.EngineType;
import java.util.EnumMap;

public class NjuskaloEngineTypeUriParser {

  private final EnumMap<EngineType, String> engineTypeUris = new EnumMap<>(EngineType.class);

  public NjuskaloEngineTypeUriParser() {
    setUp();
  }

  public String getUri(EngineType engineType) {
    return engineTypeUris.get(engineType);
  }

  private void setUp() {
    engineTypeUris.put(EngineType.diesel, "602");
    engineTypeUris.put(EngineType.petrol, "600");
    engineTypeUris.put(EngineType.hybrid, "604");
    engineTypeUris.put(EngineType.eletric, "1226");
  }
}

package com.adverts.scanner.njuskalo;

import com.adverts.scanner.domain.scan.Location;
import java.util.EnumMap;

public class NjuskaloLocationUrlParser {

  private final EnumMap<Location, String> locations = new EnumMap<>(Location.class);

  public NjuskaloLocationUrlParser() {
    setUp();
  }

  public String getUri(Location location){
    return locations.get(location);
  }

  private void setUp(){
    locations.put(Location.bjelovarsko_bilogorska, "1150");
    locations.put(Location.brodsko_posavska, "1151");
    locations.put(Location.dubrovacko_neretvanska, "1152");
    locations.put(Location.istarska, "1154");
    locations.put(Location.karlovacka, "1155");
    locations.put(Location.koprivnicko_krizevacka, "1156");
    locations.put(Location.krapinsko_zagorska, "1157");
    locations.put(Location.licko_senjska, "1158");
    locations.put(Location.medimurska, "1159");
    locations.put(Location.osjecko_baranjska, "1160");
    locations.put(Location.pozesko_slavonska, "1161");
    locations.put(Location.primorsko_goranska, "1162");
    locations.put(Location.sisacko_moslavacka, "1163");
    locations.put(Location.splitsko_dalmatinska, "1164");
    locations.put(Location.sibensko_kninska, "1165");
    locations.put(Location.varazdinska, "1166");
    locations.put(Location.viroviticko_podravska, "1167");
    locations.put(Location.vukovarsko_srijemska, "1168");
    locations.put(Location.zadarska, "1169");
    locations.put(Location.grad_zagreb, "1153");
    locations.put(Location.zagrebacka, "1170");
  }

}

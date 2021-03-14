package com.adverts.scanner.njuskalo;

import com.adverts.scanner.domain.scan.CarModel;
import java.util.HashMap;

public class NjuskaloCarUriParser {

  private final HashMap<CarModel, String> carUris = new HashMap<>();

  public NjuskaloCarUriParser(){
    setUp();
  }

  public String getUri(CarModel carModel){
    return carUris.get(carModel);
  }

  private void setUp(){
    carUris.put(CarModel.audi_80, "audi-80");
    carUris.put(CarModel.audi_80_avant, "audi_80-avant");
    carUris.put(CarModel.audi_100, "audi-100");
    carUris.put(CarModel.audi_a1, "audi-a1");
    carUris.put(CarModel.audi_a2, "audi-a2");
    carUris.put(CarModel.audi_a3, "audi-a3");
    carUris.put(CarModel.audi_a4, "audi-a4");
    carUris.put(CarModel.audi_a3_cabrio, "audi-a3-cabrio");
    carUris.put(CarModel.audi_a3_coupe, "audi-a3-coupe");
    carUris.put(CarModel.audi_a4_cabrio, "audi-a4-cabrio");
    carUris.put(CarModel.audi_a4_allroad, "audi-a4-allroad");
    carUris.put(CarModel.audi_a4_avant, "audi-a4-avant");
    carUris.put(CarModel.audi_a5_coupe, "audi-a5-coupe");
    carUris.put(CarModel.audi_a5_cabrio, "audi-a5-cabrio");
    carUris.put(CarModel.audi_a5, "audi-a5");
    carUris.put(CarModel.audi_a6_avant, "audi-a6-avant");
    carUris.put(CarModel.audi_a6_allroad, "audi-a6-allroad");
    carUris.put(CarModel.audi_a6, "audi-a6");
    carUris.put(CarModel.audi_a7, "audi-a7");
    carUris.put(CarModel.audi_a8, "audi-a8");
    carUris.put(CarModel.audi_e_tron, "audi-e-tron");
    carUris.put(CarModel.audi_q2, "audi-q2");
    carUris.put(CarModel.audi_q3, "audi-q3");
    carUris.put(CarModel.audi_q5, "audi-q5");
    carUris.put(CarModel.audi_q7, "audi-q7");
    carUris.put(CarModel.audi_q8, "audi-q8");
    carUris.put(CarModel.audi_r8, "audi-r8");
    carUris.put(CarModel.audi_rs3, "audi-rs3");
    carUris.put(CarModel.audi_rs4, "audi-rs4");
    carUris.put(CarModel.audi_rs5, "audi-rs5");
    carUris.put(CarModel.audi_rs6, "audi-rs6");
    carUris.put(CarModel.audi_s3, "audi-s3");
    carUris.put(CarModel.audi_s4, "audi-s4");
    carUris.put(CarModel.audi_s5, "audi-s5");
    carUris.put(CarModel.audi_s6_avant, "audi-s6-avant");
    carUris.put(CarModel.audi_s8, "audi-s880");
    carUris.put(CarModel.audi_tt, "audi-tt80");
  }

}

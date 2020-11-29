package com.adverts.scanner.njuskalo;


import com.adverts.scanner.domain.scan.EngineTypeDto;



public class EngineTypeMapper {

    public static String getNjuskaloId(EngineTypeDto engineTypeDto){

        if(engineTypeDto == EngineTypeDto.DIESEL ){
            return "602";
        }
        else if(engineTypeDto == EngineTypeDto.PETROL ){
            return "600";
        }
        else if(engineTypeDto == EngineTypeDto.HYBRID ){
            return "604";
        }
        else if(engineTypeDto == EngineTypeDto.ELETRIC ){
            return "1226";
        }
        else throw new IllegalArgumentException();

    }

}

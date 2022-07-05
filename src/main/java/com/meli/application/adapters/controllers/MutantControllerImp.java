package com.meli.application.adapters.controllers;

import com.meli.application.ports.controllers.MutantControllerPort;
import com.meli.domain.dto.MutantDTO;
import com.meli.domain.dto.StatsDTO;
import com.meli.domain.ports.interfaces.StatsDNAServicePort;
import com.meli.domain.ports.interfaces.ValidaDNAServicePort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MutantControllerImp implements MutantControllerPort {

    @Autowired
    private ValidaDNAServicePort validaDNAServicePort;

    @Autowired
    private StatsDNAServicePort statsDNAServicePort;

    @Override
    public ResponseEntity<Boolean> mutant(MutantDTO mutantDto) {

        for(String mutant : mutantDto.getDna()) {
            if(!(mutant.length() == 6)) {
                return new ResponseEntity<Boolean>(false, HttpStatus.LENGTH_REQUIRED);
            }
        }

        if(validaDNAServicePort.isMutant(mutantDto.getDna())) {
            return new ResponseEntity<Boolean>(true, HttpStatus.OK);
        }

        return new ResponseEntity<Boolean>(false, HttpStatus.FORBIDDEN);
    }

    @Override
    public ResponseEntity<StatsDTO> stats() {
        return new ResponseEntity<StatsDTO>(statsDNAServicePort.returnStats(), HttpStatus.OK);
    }
}

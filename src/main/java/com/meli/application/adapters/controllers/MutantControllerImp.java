package com.meli.application.adapters.controllers;

import com.meli.application.ports.controllers.MutantControllerPort;
import com.meli.domain.dto.MutantDTO;
import com.meli.domain.ports.interfaces.ValidaDNAServicePort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MutantControllerImp implements MutantControllerPort {

    @Autowired
    private ValidaDNAServicePort validaDNAServicePort;

    @Override
    public ResponseEntity<Boolean> mutantApi(MutantDTO mutantDto) {

        if(validaDNAServicePort.isMutant(mutantDto.getDna())) {
            return new ResponseEntity<Boolean>(true, HttpStatus.OK);
        }

        return new ResponseEntity<Boolean>(false, HttpStatus.FORBIDDEN);
    }
}

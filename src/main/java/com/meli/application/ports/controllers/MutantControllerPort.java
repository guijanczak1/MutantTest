package com.meli.application.ports.controllers;

import com.meli.domain.dto.MutantDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public interface MutantControllerPort {

    @PostMapping("/mutant")
    ResponseEntity<Boolean> mutantApi(@RequestBody MutantDTO mutantDto);

}

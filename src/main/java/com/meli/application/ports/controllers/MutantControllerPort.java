package com.meli.application.ports.controllers;

import com.meli.domain.dto.MutantDTO;
import com.meli.domain.dto.StatsDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public interface MutantControllerPort {

    @PostMapping("/mutant")
    ResponseEntity<Boolean> mutant(@RequestBody MutantDTO mutantDto);

    @GetMapping("/stats")
    ResponseEntity<StatsDTO> stats();

}

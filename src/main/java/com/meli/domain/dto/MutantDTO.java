package com.meli.domain.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class MutantDTO {

    @JsonProperty
    private String[] dna;

}

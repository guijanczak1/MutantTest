package com.meli.domain.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class MutantDTO {

    @JsonProperty
    public String[] dna;

}

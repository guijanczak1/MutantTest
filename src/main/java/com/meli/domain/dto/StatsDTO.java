package com.meli.domain.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class StatsDTO {

    @JsonProperty
    private Integer count_mutant_dna;

    @JsonProperty
    private Integer count_human_dna;

    @JsonProperty
    private Double ratio;

}

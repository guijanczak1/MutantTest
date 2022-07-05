package com.meli.infrastructure.adapters.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "dna")
@Data
public class DNAEntity {

    @Id
    private String dna;

}

package com.meli.infrastructure.adapters.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "dna")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DNAEntity {

    @Id
    public String dna;

}

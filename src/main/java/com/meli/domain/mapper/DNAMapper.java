package com.meli.domain.mapper;

import com.meli.domain.dto.DnaDTO;
import com.meli.infrastructure.adapters.entity.DNAEntity;
import org.springframework.stereotype.Component;

@Component
public class DNAMapper {

    public DNAEntity convertToEntity(DnaDTO dto) {
        DNAEntity entity = new DNAEntity();

        entity.setDna(dto.getDna());

        return entity;
    }

}

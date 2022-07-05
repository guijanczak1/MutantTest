package com.meli.infrastructure.adapters.repositories;

import com.meli.domain.dto.DnaDTO;
import com.meli.domain.mapper.DNAMapper;
import com.meli.domain.ports.repositories.DNARepositoryPort;
import com.meli.infrastructure.adapters.entity.DNAEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DNARepository implements DNARepositoryPort {

    @Autowired
    public DNARepositoryJPA dnaRepositoryJPA;

    @Autowired
    public DNAMapper mapper;

    @Override
    public void salvar(String[] dnas) {
        try {
            for(String dna : dnas) {
                DnaDTO dto = new DnaDTO();
                dto.setDna(dna);
                dnaRepositoryJPA.save(mapper.convertToEntity(dto));
            }
        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<DNAEntity> findAll() {
        return dnaRepositoryJPA.findAll();
    }
}

package com.meli.domain.adapters.services;

import com.meli.domain.dto.StatsDTO;
import com.meli.domain.ports.interfaces.StatsDNAServicePort;
import com.meli.domain.ports.repositories.DNARepositoryPort;
import com.meli.infrastructure.adapters.entity.DNAEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StatsDNAServiceImp implements StatsDNAServicePort {

    @Autowired
    DNARepositoryPort dnaRepository;

    @Override
    public StatsDTO returnStats() {

        List<DNAEntity> dnas;
        StatsDTO dto = new StatsDTO();
        String[] mutantDnas = new String[] { "CCCC", "AAAA", "GGGG", "TTTT", "cccc", "aaaa", "gggg", "tttt" };
        Integer mutant = 0;
        Integer human = 0;
        boolean isMutant = false;

        dnas = dnaRepository.findAll();

        for(DNAEntity dna : dnas) {
            for(String mutantDna : mutantDnas) {
                if(dna.getDna().contains(mutantDna)) {
                    mutant++;
                    isMutant = true;
                }
            }
            if(!isMutant) {
                human++;
            }

            isMutant = false;
        }

        Double mutantdouble = mutant.doubleValue();
        Double humandouble = human.doubleValue();
        Double ratioDouble = mutantdouble / humandouble;
        dto.setCount_mutant_dna(mutant);
        dto.setCount_human_dna(human);
        dto.setRatio(ratioDouble);

        return dto;
    }
}

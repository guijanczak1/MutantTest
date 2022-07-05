package com.meli.domain.adapters.services;

import com.meli.domain.ports.interfaces.ValidaDNAServicePort;
import com.meli.domain.ports.repositories.DNARepositoryPort;
import com.meli.domain.usecases.ValidaMutantUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ValidaDNAServiceImp implements ValidaDNAServicePort {

    @Autowired
    ValidaMutantUseCase validaMutantUseCase;

    @Autowired
    DNARepositoryPort dnaRepository;

    @Override
    public boolean isMutant(String[] dna) {

        dnaRepository.salvar(dna);

        if(validaMutantUseCase.validaHorizontal(dna) ||
                validaMutantUseCase.validaVertical(dna) ||
                validaMutantUseCase.validaDiagonal(dna)) {
            return true;
        }

        return false;
    }
}

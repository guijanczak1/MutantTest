package com.meli.domain.ports.repositories;

import com.meli.infrastructure.adapters.entity.DNAEntity;

import java.util.List;

public interface DNARepositoryPort {

    void salvar(String[] dnas);

    List<DNAEntity> findAll();

}

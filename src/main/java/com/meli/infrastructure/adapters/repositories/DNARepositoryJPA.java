package com.meli.infrastructure.adapters.repositories;

import com.meli.infrastructure.adapters.entity.DNAEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DNARepositoryJPA extends JpaRepository<DNAEntity, String> {
}

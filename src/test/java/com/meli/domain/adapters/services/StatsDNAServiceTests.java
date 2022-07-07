package com.meli.domain.adapters.services;

import com.meli.domain.dto.StatsDTO;
import com.meli.domain.ports.interfaces.StatsDNAServicePort;
import com.meli.domain.ports.repositories.DNARepositoryPort;
import com.meli.infrastructure.adapters.entity.DNAEntity;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.doReturn;

@SpringBootTest
class StatsDNAServiceTests {
    @Mock
    private DNARepositoryPort dnaRepository;

    @InjectMocks
    private StatsDNAServicePort stats = new StatsDNAServiceImp();

    public List<DNAEntity> entity = new ArrayList<>();
    public StatsDTO dto = new StatsDTO();

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);

        entity.add(new DNAEntity("XQEQSD"));
        entity.add(new DNAEntity("CCCCCC"));

        dto.setCount_human_dna(1);
        dto.setCount_mutant_dna(1);
    }

    @DisplayName("Test spring metodo - returnStatus")
    @Test
    void TestReturnStatus() {
        doReturn(entity).when(dnaRepository).findAll();

        StatsDTO dto = new StatsDTO();

        dto.setCount_human_dna(1);
        assertEquals(dto.getCount_human_dna(), stats.returnStats().getCount_human_dna());
    }
}

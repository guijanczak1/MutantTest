package com.meli.domain.mapper;

import com.meli.domain.dto.DnaDTO;
import com.meli.infrastructure.adapters.entity.DNAEntity;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class DNAMapperTests {

    @InjectMocks
    private DNAMapper dnaMapper;

    public DNAEntity entity = new DNAEntity();
    public DnaDTO dto = new DnaDTO();

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);

        entity.setDna("XQEQSD");
        dto.setDna("XQEQSD");
    }

    @DisplayName("Test spring mapper - convertToEntity")
    @Test
    void testMapper() {
        assertEquals(dto.getDna(), dnaMapper.convertToEntity(dto).getDna());
    }

}

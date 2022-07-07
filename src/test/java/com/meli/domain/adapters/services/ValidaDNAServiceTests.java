package com.meli.domain.adapters.services;

import com.meli.domain.ports.interfaces.ValidaDNAServicePort;
import com.meli.domain.ports.repositories.DNARepositoryPort;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class ValidaDNAServiceTests {

    @Autowired
    private ValidaDNAServicePort validaDNA = new ValidaDNAServiceImp();

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @DisplayName("Test spring metodo - isMutant / True")
    @Test
    void TestIsMutantThenTrue() {
        String[] dnas = new String[] { "CCCCCC", "AAAAAA", "GGGGGG", "TTTTTT", "ZZZZZZ", "DDDDDD" };

        assertEquals(true, validaDNA.isMutant(dnas));
    }

    @DisplayName("Test spring metodo - isMutant / False")
    @Test
    void TestIsMutantThenFalse() {
        String[] dnas = new String[] { "DDDDDD", "DDDDDD", "DDDDDD", "DDDDDD", "DDDDDD", "DDDDDD" };

        assertEquals(false, validaDNA.isMutant(dnas));
    }
}

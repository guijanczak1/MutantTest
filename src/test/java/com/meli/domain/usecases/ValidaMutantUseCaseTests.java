package com.meli.domain.usecases;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class ValidaMutantUseCaseTests {

    @Autowired
    private ValidaMutantUseCase validaMutantUseCase;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @DisplayName("Test spring metodo - ValidaHorizontal / True")
    @Test
    void testValidaHorizontalTrue() {
        String[] dnas = new String[] { "CCCCCC", "AAAAAA", "GGGGGG", "TTTTTT", "ZZZZZZ", "DDDDDD" };
        assertEquals(true, validaMutantUseCase.validaHorizontal(dnas));
    }

    @DisplayName("Test spring metodo - ValidaHorizontal / False")
    @Test
    void testValidaHorizontalFalse() {
        String[] dnas = new String[] { "DDDDDD", "DDDDDD", "DDDDDD", "DDDDDD", "DDDDDD", "DDDDDD" };
        assertEquals(false, validaMutantUseCase.validaHorizontal(dnas));
    }

    @DisplayName("Test spring metodo - ValidaVertical / True")
    @Test
    void testValidaVerticalTrue() {
        String[] dnas = new String[] { "CCCCCC", "CAAAAA", "CGGGGG", "CTTTTT", "ZZZZZZ", "DDDDDD" };
        assertEquals(true, validaMutantUseCase.validaVertical(dnas));
    }

    @DisplayName("Test spring metodo - ValidaVertical / False")
    @Test
    void testValidaVerticalFalse() {
        String[] dnas = new String[] { "DDDDDD", "DDDDDD", "DDDDDD", "DDDDDD", "DDDDDD", "DDDDDD" };
        assertEquals(false, validaMutantUseCase.validaVertical(dnas));
    }

    @DisplayName("Test spring metodo - validaDiagonal / True")
    @Test
    void testValidaDiagonalTrue() {
        String[] dnas = new String[] { "CCCCCC", "CCCCCC", "CCCCCC", "CCCCCC", "CCCCCC", "CCCCCC" };
        assertEquals(true, validaMutantUseCase.validaDiagonal(dnas));
    }

    @DisplayName("Test spring metodo - validaDiagonal / False")
    @Test
    void testValidaDiagonalFalse() {
        String[] dnas = new String[] { "DDDDDD", "DDDDDD", "DDDDDD", "DDDDDD", "DDDDDD", "DDDDDD" };
        assertEquals(false, validaMutantUseCase.validaDiagonal(dnas));
    }

    @DisplayName("Test spring metodo - validaDiagonalIndiceFiveToLeftAndFiveForUp / True")
    @Test
    void testValidaDiagonalIndiceFiveToLeftAndFiveForUpTrue() {
        String[] dnas = new String[] { "CCCCCC", "CCCCCC", "CCCCCC", "CCCCCC", "CCCCCC", "CCCCCC" };
        String[] mutantDnas = new String[] { "CCCC", "AAAA", "GGGG", "TTTT", "cccc", "aaaa", "gggg", "tttt" };
        assertEquals(true, validaMutantUseCase.validaDiagonalIndiceFiveToLeftAndFiveForUp(dnas, mutantDnas));
    }

    @DisplayName("Test spring metodo - validaDiagonalIndiceFiveToLeftAndFiveForUp / False")
    @Test
    void testValidaDiagonalIndiceFiveToLeftAndFiveForUpFalse() {
        String[] dnas = new String[] { "DDDDDD", "DDDDDD", "DDDDDD", "DDDDDD", "DDDDDD", "DDDDDD" };
        String[] mutantDnas = new String[] { "CCCC", "AAAA", "GGGG", "TTTT", "cccc", "aaaa", "gggg", "tttt" };
        assertEquals(false, validaMutantUseCase.validaDiagonalIndiceFiveToLeftAndFiveForUp(dnas, mutantDnas));
    }

    @DisplayName("Test spring metodo - validaDiagonalIndiceZeroToRightAndZeroForUp / True")
    @Test
    void testValidaDiagonalIndiceZeroToRightAndZeroForUpTrue() {
        String[] dnas = new String[] { "CCCCCC", "CCCCCC", "CCCCCC", "CCCCCC", "CCCCCC", "CCCCCC" };
        String[] mutantDnas = new String[] { "CCCC", "AAAA", "GGGG", "TTTT", "cccc", "aaaa", "gggg", "tttt" };
        assertEquals(true, validaMutantUseCase.validaDiagonalIndiceZeroToRightAndZeroForUp(dnas, mutantDnas));
    }

    @DisplayName("Test spring metodo - validaDiagonalIndiceZeroToRightAndZeroForUp / False")
    @Test
    void testValidaDiagonalIndiceZeroToRightAndZeroForUpFalse() {
        String[] dnas = new String[] { "DDDDDD", "DDDDDD", "DDDDDD", "DDDDDD", "DDDDDD", "DDDDDD" };
        String[] mutantDnas = new String[] { "CCCC", "AAAA", "GGGG", "TTTT", "cccc", "aaaa", "gggg", "tttt" };
        assertEquals(false, validaMutantUseCase.validaDiagonalIndiceZeroToRightAndZeroForUp(dnas, mutantDnas));
    }

    @DisplayName("Test spring metodo - validaDiagonalIndiceFiveToLeftAndFiveForDown / True")
    @Test
    void testValidaDiagonalIndiceFiveToLeftAndFiveForDownTrue() {
        String[] dnas = new String[] { "CCCCCC", "CCCCCC", "CCCCCC", "CCCCCC", "CCCCCC", "CCCCCC" };
        String[] mutantDnas = new String[] { "CCCC", "AAAA", "GGGG", "TTTT", "cccc", "aaaa", "gggg", "tttt" };
        assertEquals(true, validaMutantUseCase.validaDiagonalIndiceFiveToLeftAndFiveForDown(dnas, mutantDnas));
    }

    @DisplayName("Test spring metodo - validaDiagonalIndiceFiveToLeftAndFiveForDown / False")
    @Test
    void testValidaDiagonalIndiceFiveToLeftAndFiveForDownFalse() {
        String[] dnas = new String[] { "DDDDDD", "DDDDDD", "DDDDDD", "DDDDDD", "DDDDDD", "DDDDDD" };
        String[] mutantDnas = new String[] { "CCCC", "AAAA", "GGGG", "TTTT", "cccc", "aaaa", "gggg", "tttt" };
        assertEquals(false, validaMutantUseCase.validaDiagonalIndiceFiveToLeftAndFiveForDown(dnas, mutantDnas));
    }

    @DisplayName("Test spring metodo - validaDiagonalIndiceZeroToRightAndZeroForDown / True")
    @Test
    void testValidaDiagonalIndiceZeroToRightAndZeroForDownTrue() {
        String[] dnas = new String[] { "CCCCCC", "CCCCCC", "CCCCCC", "CCCCCC", "CCCCCC", "CCCCCC" };
        String[] mutantDnas = new String[] { "CCCC", "AAAA", "GGGG", "TTTT", "cccc", "aaaa", "gggg", "tttt" };
        assertEquals(true, validaMutantUseCase.validaDiagonalIndiceZeroToRightAndZeroForDown(dnas, mutantDnas));
    }

    @DisplayName("Test spring metodo - validaDiagonalIndiceZeroToRightAndZeroForDown / False")
    @Test
    void testValidaDiagonalIndiceZeroToRightAndZeroForDownFalse() {
        String[] dnas = new String[] { "DDDDDD", "DDDDDD", "DDDDDD", "DDDDDD", "DDDDDD", "DDDDDD" };
        String[] mutantDnas = new String[] { "CCCC", "AAAA", "GGGG", "TTTT", "cccc", "aaaa", "gggg", "tttt" };
        assertEquals(false, validaMutantUseCase.validaDiagonalIndiceZeroToRightAndZeroForDown(dnas, mutantDnas));
    }

    @DisplayName("Test spring metodo - validaDnaMutant / True")
    @Test
    void testValidaDnaMutantTrue() {
        String[] mutantDnas = new String[] { "CCCC", "AAAA", "GGGG", "TTTT", "cccc", "aaaa", "gggg", "tttt" };
        String dna = "CCCCCC";
        assertEquals(true, validaMutantUseCase.validaDnaMutant(dna, mutantDnas));
    }

    @DisplayName("Test spring metodo - validaDnaMutant / False")
    @Test
    void testValidaDnaMutantFalse() {
        String[] mutantDnas = new String[] { "CCCC", "AAAA", "GGGG", "TTTT", "cccc", "aaaa", "gggg", "tttt" };
        String dna = "DDDDDD";
        assertEquals(false, validaMutantUseCase.validaDnaMutant(dna, mutantDnas));
    }

    @DisplayName("Test spring metodo - validaLetra / True")
    @Test
    void testValidaLetraTrue() {
        String letra = "C";
        int contadorLetra = 4;
        assertEquals(true, validaMutantUseCase.validaLetra(letra, contadorLetra));
    }

    @DisplayName("Test spring metodo - validaLetra / False")
    @Test
    void testValidaLetraFalse() {
        String letra = "D";
        int contadorLetra = 1;
        assertEquals(false, validaMutantUseCase.validaLetra(letra, contadorLetra));
    }

}

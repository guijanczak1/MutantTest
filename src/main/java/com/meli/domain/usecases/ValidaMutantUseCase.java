package com.meli.domain.usecases;

import org.springframework.stereotype.Service;

@Service
public class ValidaMutantUseCase {

    public boolean validaHorizontal(String[] dna) {
        for(String dnaLinha : dna) {
            String ultimaLetra = "";
            String[] dnaSplit = dnaLinha.split("");
            int contadorLetraDNA = 0;

            for(String dnaLetra: dnaSplit) {
                if(!ultimaLetra.equals(dnaLetra)) {
                    contadorLetraDNA = 0;
                }

                ultimaLetra = dnaLetra;
                contadorLetraDNA++;

                if (validaLetra(ultimaLetra, contadorLetraDNA))
                    return true;
            }
        }
        return false;
    }

    public boolean validaVertical(String[] dna) {
        String strDna = "";

        for(String dnaLinha : dna) {
            String[] dnaSplit = dnaLinha.split("");
            strDna += String.join("", dnaSplit);
        }

        String[] strDnaSplit = strDna.split("");
        String ultimaLetra = "";

        for(int i=0; i<6; i++) {
            int contadorDna = 0;
            for(int j=i; j<=30 + i; j+=6) {
                
                if(!ultimaLetra.equals(strDnaSplit[j])) {
                    contadorDna = 0;
                }

                ultimaLetra = strDnaSplit[j];
                contadorDna++;

                if (validaLetra(ultimaLetra, contadorDna))
                    return true;
            }
        }
        return false;
    }

    public boolean validaDiagonal(String[] dna) {
        String[] mutantDnas = new String[] { "CCCC", "AAAA", "GGGG", "TTTT" };
        
        //INDICE 0 COLUNA 0 PRA DIREITA/INDICE 0 PRA BAIXO
        if (ValidaDiagonalIndiceZeroToRightAndZeroForDown(dna, mutantDnas)) return true;

        //INDICE 5 COLUNA 0 PRA ESQUERDA/INDICE 5 PRA BAIXO
        if (ValidaDiagonalIndiceFiveToLeftAndFiveForDown(dna, mutantDnas)) return true;

        //INDICE 0 COLUNA 5 PRA DIREITA/INDICE 0 PRA CIMA
        if (ValidaDiagonalIndiceZeroToRightAndZeroForUp(dna, mutantDnas)) return true;

        //INDICE 5 COLUNA 5 PRA ESQUERDA/INDICE 5 PRA CIMA
        if (ValidaDiagonalIndiceFiveToLeftAndFiveForUp(dna, mutantDnas)) return true;

        return false;
    }

    private boolean ValidaDiagonalIndiceFiveToLeftAndFiveForUp(String[] dna, String[] mutantDnas) {
        for(int i=5; i<6; i--) {
            String strLinhaDiagonal = "";
            int colunaBaixo = 0;
            int contadorbreak = 0;
            if(i < 3) {
                if(i == 0) break;
                for(int j=5; j < 6; j--) {
                    if(contadorbreak == 9 || j == 0) {
                        break;
                    }
                    String dnaLine = dna[colunaBaixo - 1];
                    String[] dnaSplit = dnaLine.split("");
                    strLinhaDiagonal += dnaSplit[j];
                    colunaBaixo--;
                    contadorbreak++;
                }

                if (validaDnaMutant(strLinhaDiagonal, mutantDnas)) return true;

                strLinhaDiagonal = "";
                colunaBaixo = 4;
            }
            else {
                for (int j = i; j < 6; j--) {
                    if(j < 0) {
                        break;
                    }
                    String dnaLine = dna[colunaBaixo];
                    String[] dnaSplit = dnaLine.split("");
                    strLinhaDiagonal += dnaSplit[j];
                    colunaBaixo--;
                }

                if (validaDnaMutant(strLinhaDiagonal, mutantDnas)) return true;

                strLinhaDiagonal = "";
                colunaBaixo = 5;
            }
        }
        return false;
    }

    private boolean ValidaDiagonalIndiceZeroToRightAndZeroForUp(String[] dna, String[] mutantDnas) {
        for(int i=0; i<5; i++) {
            String strLinhaDiagonal = "";
            int colunaBaixo = 0;
            int contadorbreak = 0;
            if(i >= 3) {
                for(int j=0; j < 5; j++) {
                    if(contadorbreak == 9) {
                        break;
                    }
                    String dnaLine = dna[colunaBaixo - 1];
                    String[] dnaSplit = dnaLine.split("");
                    strLinhaDiagonal += dnaSplit[j];
                    colunaBaixo--;
                    contadorbreak++;
                }

                if (validaDnaMutant(strLinhaDiagonal, mutantDnas)) return true;

                strLinhaDiagonal = "";
                colunaBaixo = 4;
            }
            else {
                for (int j = i; j < 6; j++) {
                    String dnaLine = dna[colunaBaixo];
                    String[] dnaSplit = dnaLine.split("");
                    strLinhaDiagonal += dnaSplit[j];
                    colunaBaixo--;
                }

                if (validaDnaMutant(strLinhaDiagonal, mutantDnas)) return true;

                strLinhaDiagonal = "";
                colunaBaixo = 5;
            }
        }
        return false;
    }

    private boolean ValidaDiagonalIndiceFiveToLeftAndFiveForDown(String[] dna, String[] mutantDnas) {
        for(int i=5; i<6; i--) {
            String strLinhaDiagonal = "";
            int coluna = 0;
            int contadorbreak = 0;
            if(i < 3) {
                if(i == 0) break;
                for(int j=5; j < 6; j--) {
                    if(contadorbreak == 9 || j == 0) {
                        break;
                    }
                    String dnaLine = dna[coluna + 1];
                    String[] dnaSplit = dnaLine.split("");
                    strLinhaDiagonal += dnaSplit[j];
                    coluna++;
                    contadorbreak++;
                }

                if (validaDnaMutant(strLinhaDiagonal, mutantDnas)) return true;

                strLinhaDiagonal = "";
                coluna = 1;
            }
            else {
                for (int j = i; j < 6; j--) {
                    if(j < 0) {
                        break;
                    }
                    String dnaLine = dna[coluna];
                    String[] dnaSplit = dnaLine.split("");
                    strLinhaDiagonal += dnaSplit[j];
                    coluna++;
                }

                if (validaDnaMutant(strLinhaDiagonal, mutantDnas)) return true;

                strLinhaDiagonal = "";
                coluna = 0;
            }
        }
        return false;
    }

    private boolean ValidaDiagonalIndiceZeroToRightAndZeroForDown(String[] dna, String[] mutantDnas) {
        for(int i=0; i<5; i++) {
            String strLinhaDiagonal = "";
            int coluna = 0;
            int contadorbreak = 0;
            if(i >= 3) {
                for(int j=0; j < 5; j++) {
                    if(contadorbreak == 9) {
                        break;
                    }
                    String dnaLine = dna[coluna + 1];
                    String[] dnaSplit = dnaLine.split("");
                    strLinhaDiagonal += dnaSplit[j];
                    coluna++;
                    contadorbreak++;
                }

                if (validaDnaMutant(strLinhaDiagonal, mutantDnas)) return true;

                strLinhaDiagonal = "";
                coluna = 1;
            }
            else {
                for (int j = i; j < 6; j++) {
                    String dnaLine = dna[coluna];
                    String[] dnaSplit = dnaLine.split("");
                    strLinhaDiagonal += dnaSplit[j];
                    coluna++;
                }

                if (validaDnaMutant(strLinhaDiagonal, mutantDnas)) return true;

                strLinhaDiagonal = "";
                coluna = 0;
            }
        }
        return false;
    }

    private boolean validaDnaMutant(String strLinhaDiagonal, String[] mutantDnas) {
        for(String mutantDna : mutantDnas) {
            if(strLinhaDiagonal.contains(mutantDna)) {
                return true;
            }
        }
        return false;
    }

    private boolean validaLetra(String ultimaLetra, int contadorLetraDNA) {
        if(contadorLetraDNA == 4) {
            if(ultimaLetra.equalsIgnoreCase("A") ||
                    ultimaLetra.equalsIgnoreCase("T") ||
                    ultimaLetra.equalsIgnoreCase("C") ||
                    ultimaLetra.equalsIgnoreCase("G")) {
                return true;
            }
        }
        return false;
    }
}

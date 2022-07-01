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
        return false;
    }

    private boolean validaLetra(String ultimaLetra, int contadorLetraDNA) {
        if(contadorLetraDNA == 4) {
            if(ultimaLetra.equals("A") ||
                    ultimaLetra.equals("T") ||
                    ultimaLetra.equals("C") ||
                    ultimaLetra.equals("G")) {
                return true;
            }
        }
        return false;
    }
}

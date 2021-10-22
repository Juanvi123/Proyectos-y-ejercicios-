/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sopa_letras;

import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author juanv
 */
public class Generadores_Letras extends Thread {

    //CONSTANTES
    private static final char LETRA_INICIAL = 'a';
    private static final char LETRA_FINAL = 'z';
    //INSTANCIAMOS RC
    RC_Letras rC_Letras;
    //VARIABLES
    char letra;
    int nLetra;

    //CONSTRUCTOR
    public Generadores_Letras(RC_Letras rC_Letras) {
        this.rC_Letras = rC_Letras;
        this.nLetra = 0;
    }

    @Override
    public void run() {
        try {
            while (true) {
                this.sleep(10);
                //GENERA LETRA
                nLetra = new Random().nextInt((LETRA_FINAL - LETRA_INICIAL) + 1) + LETRA_INICIAL;
                letra = (char) nLetra;
                //METEMOS LETRA EN RC
                rC_Letras.addLetra(letra);

            }
        } catch (InterruptedException ex) {
            Logger.getLogger(Generadores_Letras.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}

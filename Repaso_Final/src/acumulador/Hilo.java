/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package acumulador;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author juanv
 */
public class Hilo extends Thread {

    //CONSTANTES
    private static final int N_INCREMENTO = 3;
    private static final int TIEMPO = 500;

    //INSTANCIAMOS RC
    RC_Acumulador acumulador;

    //VARIABLES 
    private int incremento;

    //CONSTRUCTOR
    public Hilo(RC_Acumulador acumulador) {
        this.acumulador = acumulador;
        this.incremento = 1;
    }

    @Override
    public void run() {
        try {
            for (int i = 0; i < N_INCREMENTO; i++) {
                //TIEMPO ENTRE HILO E HILO
                this.sleep(TIEMPO);
                //METEMOS EL INCREMENTO EN EL RC
                acumulador.addIncremento(incremento);
            }
        } catch (InterruptedException ex) {
            Logger.getLogger(Hilo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}

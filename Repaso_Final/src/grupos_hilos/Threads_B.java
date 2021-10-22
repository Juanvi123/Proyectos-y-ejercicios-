/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grupos_hilos;

import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author juanv
 */
public class Threads_B extends Thread {
    //CONSTANTES

    private static final int TIEMPO_MIN = 1000;
    private static final int TIEMPO_MAX = 2000;
    private static final int N_MAX = 10;
    private static final int N_MIN = 1;

    //INSTANCIAMOS RC
    RC_Suma_Numeros suma_Numeros;

    //VARIABLES
    private int n;

    //BOOLEANO PARA CONTROLAR INTERRUPCIÓN
    private boolean interrupt; //true INTERRUMPIDO, false NO INTERRUMPIDO

    //CONSTRUCTOR
    public Threads_B(RC_Suma_Numeros suma_Numeros) {
        this.suma_Numeros = suma_Numeros;
        this.n = 0;
        this.interrupt = false;
    }

    //BLOQUE DE EJECUCIÓN
    @Override
    public void run() {
        try {
            //MIENTRAS NO SEAS INTERRUMPIDO
            while (!interrupt) {
                //TIEMPO ENTRE HILO E HILO
                this.sleep(new Random().nextInt((TIEMPO_MAX - TIEMPO_MIN) + 1) + TIEMPO_MIN);
                //GENERAMOS ALEATORIAMENTE UN Nº ENTRE 1 Y 10
                n = new Random().nextInt((N_MAX - N_MIN) + 1) + N_MIN;
                //METEMOS Nº EN RC
                suma_Numeros.addNumero(n);
            }
        } catch (InterruptedException ex) {
            interrupt = true;
            System.out.println(getName() + " FIN");
        }
    }

}

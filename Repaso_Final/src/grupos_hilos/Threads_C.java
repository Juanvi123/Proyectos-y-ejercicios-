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
public class Threads_C extends Thread {

    //CONSTANTES
    private static final int TIEMPO_MIN = 1000;
    private static final int TIEMPO_MAX = 2000;

    //INSTANCIAMOS RC
    RC_Suma_Numeros suma_Numeros;

    //BOOLEANO PARA CONTROLAR INTERRUPCIÓN
    private boolean interrupt; //true INTERRUMPIDO, false NO INTERRUMPIDO

    public Threads_C(RC_Suma_Numeros suma_Numeros) {
        this.suma_Numeros = suma_Numeros;
        this.interrupt = false;
    }

    @Override
    public void run() {
        try {
            while (!interrupt) {
                //TIEMPO ENTRE HILO E HILO
                this.sleep(new Random().nextInt((TIEMPO_MAX - TIEMPO_MIN) + 1) + TIEMPO_MIN);
                //REALIZAMOS LA SUMA
                suma_Numeros.sumarNumeros();
            }
        } catch (InterruptedException ex) {
            interrupt=true;
            System.out.println(getName()+" FIN");
        }
    }

}

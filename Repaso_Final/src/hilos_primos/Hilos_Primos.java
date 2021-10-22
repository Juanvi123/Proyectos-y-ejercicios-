/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hilos_primos;

import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author juanv
 */
public class Hilos_Primos extends Thread {

    //CONSTANTES
    private static final int TIEMPO_MIN = 300;
    private static final int TIEMPO_MAX = 1000;

    //INSTANCIAMOS RC
    RC_Comprobar_Numero comprobar_Numero;

    //BOOLEANO PARA CONTROLAR INTERRUPCIÓN
    private boolean interrupt;

    private int n;
    private int cont;

    //CONSTRUCTOR
    public Hilos_Primos(RC_Comprobar_Numero comprobar_Numero) {
        this.comprobar_Numero = comprobar_Numero;
        this.n = 0;
        this.cont = 0;
    }

    //BLOQUE DE EJECUCIÓN
    @Override
    public void run() {
        try {
            while (!interrupt) {
                //TIEMPO ENTRE HILOS PRIMOS
                this.sleep(new Random().nextInt((TIEMPO_MAX-TIEMPO_MIN)+1) + TIEMPO_MIN);
                synchronized (comprobar_Numero) {
                    while (comprobar_Numero.getCount() == 0) {
                        comprobar_Numero.wait();
                    }
                    //POR UN LADO LO ELIMINAMOS Y X OTRO SE LO PASAMOS AL HILO PRIMO
                    n = comprobar_Numero.removeNumero().getN();
                    for (int i = n; i > 0; i--) {
                        if (n % i == 0) {
                            cont++;
                        }
                    }
                    if (cont == 2) {
                        System.out.println(n+" es primo");
                        getThreadGroup().interrupt();
                    } else {
                        System.out.println(getName()+" dice que "+n + " no es primo");
                    }
                    comprobar_Numero.notifyAll();
                }
            }

        } catch (InterruptedException ex) {
            interrupt = true;
            System.out.println(getName() + " FIN");
        }
    }

}

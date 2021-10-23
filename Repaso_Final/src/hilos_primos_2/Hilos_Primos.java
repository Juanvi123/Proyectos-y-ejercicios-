/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hilos_primos_2;

import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author juanv
 */
public class Hilos_Primos extends Thread {

    //CONSTANTES
    private static final int N_MIN = 1;
    private static final int N_MAX = 10;
    private static final int TIEMPO_MIN = 500;
    private static final int TIEMPO_MAX = 1000;

    //DECLARAMOS VARIABLES 
    private int n;

    //INSTANCIAMOS RC
    RC_N rc_n;

    //BOOLEANO PARA CONTROLAR LA INTERRUPCION
    private boolean primo;
    private int cont;

    public Hilos_Primos(RC_N rc_n) {
        this.rc_n = rc_n;
        this.n = 0;
        this.primo = false;
        this.cont = 0;
    }

    @Override
    public void run() {
        try {
            //TIEMPO ENTRE HILOS
            this.sleep(new Random().nextInt((TIEMPO_MAX - TIEMPO_MIN) + 1) + TIEMPO_MIN);
            synchronized (rc_n) {
                while (!primo) {
                    System.out.println(getName() + " le llega nº" + rc_n.getN());
                    n = rc_n.getN();
                    for (int i = n; i > 0; i--) {
                        if (n % i == 0) {
                            cont++;
                        }
                    }
                    if (cont == 2) {
                        System.out.println(n + " es primo");
                        primo = true;
                        getThreadGroup().interrupt();
                    } else {
                        System.out.println(n + " no es primo");
                    }
                    rc_n.notifyAll();
                }
            }
        } catch (InterruptedException ex) {
            System.out.println(getName()+" FIN");
        }
    }

}

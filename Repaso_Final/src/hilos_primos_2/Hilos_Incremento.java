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
public class Hilos_Incremento extends Thread {
    //CONSTANTES

    private static final int N_MIN = 1;
    private static final int N_MAX = 10;
    private static final int TIEMPO_MIN = 500;
    private static final int TIEMPO_MAX = 1000;
    //DECLARAMOS VARIABLES 
    private int n;

    //INSTANCIAMOS RC
    RC_N rc_n;
    private boolean primo;

    //CONSTRUCTOR
    public Hilos_Incremento(RC_N rc_n) {
        this.rc_n = rc_n;
        this.n = new Random().nextInt((N_MAX - N_MIN) + 1) + N_MIN;
        this.primo = false;
    }

    //BLOQUE DE EJECUCIÓN
    @Override
    public void run() {
        while (!primo) {
            try {
                //ECO INICIAL
                System.out.println(getName() + " nº inicial: " + n);
                //TIEMPO ENTRE HILOS
                this.sleep(new Random().nextInt((TIEMPO_MAX - TIEMPO_MIN) + 1) + TIEMPO_MIN);
                synchronized (rc_n) {
                    //INCREMENTAMOS VALOR
                    System.out.println(getName() + " incrementa nº (" + rc_n.getClass() + "+" + n + "="
                            + (rc_n.getN() + n));
                    rc_n.setN(rc_n.getN() + n);
                    //NOTIFICAMOS A TODOS
                    rc_n.notifyAll();
                }
            } catch (InterruptedException ex) {
                primo = true;
                System.out.println(getName() + " FIN");
            }
        }

    }

}

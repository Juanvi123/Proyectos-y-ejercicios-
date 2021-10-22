/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hilos_espera_hilo;

import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author juanv
 */
public class Thread_Hilo extends Thread {
    //CONSTANTES
    private static final int N_MIN=500;
    private static final int N_MAX=1000;
    
    //VARIABLES
    private int n;
    private Thread hilo;

    //CONSTRUCTOR
    public Thread_Hilo(Thread hilo) {
        this.hilo = hilo;
        this.n=new Random().nextInt((N_MAX-N_MIN)+1)+N_MIN;
    }

    //BLOQUE DE EJECUCIÓN
    @Override
    public void run() {
        try {
            System.out.println(getName()+" espera "+n+"s, espera a "+hilo.getName());
            this.sleep(n);
            System.out.println(getName()+" FIN");
            this.join();
        } catch (InterruptedException ex) {
            Logger.getLogger(Thread_Hilo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hilos_go;

import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author juanv
 */
public class Hilos_Go extends Thread {

    //CONSTANTES
    private static final int TIEMPO_MIN = 500;
    private static final int TIEMPO_MAX = 1000;

    //INSTANCIAMOS RC
    RC_Volatile rC_Volatile;

    //CONSTRUCTOR
    public Hilos_Go(RC_Volatile rC_Volatile) {
        this.rC_Volatile = rC_Volatile;
    }

    //BLOQUE DE EJECUCIÓN
    @Override
    public void run() {
        try {
            while (rC_Volatile.getVariableVolatil().trim().toUpperCase().equals("STOP")) {
                //TIEMPO ENTRE HILOS
                this.sleep(new Random().nextInt((TIEMPO_MAX - TIEMPO_MIN) + 1) + TIEMPO_MIN);
                System.out.println(getName() + " espera");
            }
            System.out.println(getName()+" FIN");

        } catch (InterruptedException ex) {
            Logger.getLogger(Hilos_Go.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}

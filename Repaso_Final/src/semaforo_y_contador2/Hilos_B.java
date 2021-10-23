/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package semaforo_y_contador2;

import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author juanv
 */
public class Hilos_B extends Thread {

    //CONSTANTES
    private static final int TIEMPO_MIN = 35;
    private static final int TIEMPO_MAX = 75;
    private static final int N_MIN = 9;
    private static final int N_MAX = 200;

    //VARIABLES
    private int n;
    private int cont;
    //INSTANCIAMOS RC
    Semaforo semaforo;

    //CONSTRUCTOR
    public Hilos_B(Semaforo semaforo) {
        this.semaforo = semaforo;
        this.n = new Random().nextInt((N_MAX - N_MIN) + 1) + N_MIN;
        this.cont = 0;
    }

    //BLOQUE DE EJECUCIÓN
    @Override
    public void run() {
        try {
            //ECO INICIAL
            System.out.println(getName()+" n= "+n);
            while (n > cont) {
                //TIEMPO ENTRE HILOS B
                this.sleep(new Random().nextInt((TIEMPO_MAX - TIEMPO_MIN) + 1) + TIEMPO_MIN);
                synchronized (semaforo) {
                    if (!semaforo.isSemaforo()) {
                        System.out.println(getName() + " espera");
                        while (!semaforo.isSemaforo()) {
                            semaforo.wait();
                        }
                    }else{
                        //INCREMENTAMOS EL CONTADOR
                        cont++;
                        System.out.println(getName()+" corre");
                    }
                }
            }
            System.out.println(getName()+" FIN. cont: "+cont+", n: "+n);
        } catch (InterruptedException ex) {
            Logger.getLogger(Hilos_B.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}

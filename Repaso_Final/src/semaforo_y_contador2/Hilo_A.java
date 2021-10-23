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
public class Hilo_A extends Thread {

    //CONSTANTES
    private static final int TIEMPO_MIN = 5;
    private static final int TIEMPO_MAX = 15;

    //INSTANCIAMOS RC
    Semaforo semaforo;

    //CONSTRUCTOR
    public Hilo_A(Semaforo semaforo) {
        this.semaforo = semaforo;
    }

    //BLOQUE DE EJECUCIÓN
    @Override
    public void run() {
        try {
            while (true) {
                //TIEMPO PARA CAMBIAR EL SEMAFORO
                this.sleep(new Random().nextInt((TIEMPO_MAX - TIEMPO_MIN) + 1) + TIEMPO_MIN);
                synchronized (semaforo) {
                   //CAMBIAMOS EL SEMAFORO
                   semaforo.setSemaforo();
                   //NOTIFICAMOS A TODOS
                   semaforo.notifyAll();
                }
            }
        } catch (InterruptedException ex) {
            Logger.getLogger(Hilo_A.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}

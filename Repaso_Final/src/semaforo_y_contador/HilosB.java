/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package semaforo_y_contador;

import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author juanv
 */
public class HilosB extends Thread {

    //CONSTANTES
    private static final int N_MIN = 9;
    private static final int N_MAX = 200;
    private static final int TIEMPO_MIN = 5;
    private static final int TIEMPO_MAX = 15;

    //INSTANCIAMOS RC
    RC_Semaforo semaforo;

    //CONTADOR
    private int cont;

    //Nº
    private int n;

    //CONSTRUCTOR
    public HilosB(RC_Semaforo semaforo) {
        this.semaforo = semaforo;
        this.cont = 0;
        this.n = new Random().nextInt((N_MAX - N_MIN) + 1) + N_MIN;
    }

    //BLOQUE DE EJECUCIÓN
    @Override
    public void run() {
        try {
            System.out.println(getName() + " nº inicial: " + n);
            //MIENTRAS EL CONTADOR SEA MENOR A N
            while (cont < n) {
                //TIEMPO ENTRE VUELTA Y VUELTA
                this.sleep(new Random().nextInt((TIEMPO_MAX-TIEMPO_MIN)+1)+TIEMPO_MIN);
                synchronized (semaforo) {
                    while (!semaforo.isSemaforo()) {
                        semaforo.wait();
                    }
                    //INCREMENTAMOS CONTADOR
                    cont++;
                    //NOTIFICAMOS A TODOS
                    semaforo.notifyAll();
                }
            }
            //ECOS
            System.out.println(getName() + " ha dado " + n + " vueltas, FIN");
        } catch (InterruptedException ex) {
            Logger.getLogger(HilosB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}

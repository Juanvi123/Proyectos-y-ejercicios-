/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package contador_y_semaforo_metodos;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author juanv
 */
public class Thread_2 extends Thread {

    //CONSTANTES
    private static final int TIEMPO = 500;
    private static final int N_WAIT = 8;
    //INSTANCIAMOS RC
    Contador contador;

    //CONSTRUCTOR
    public Thread_2(Contador contador) {
        this.contador = contador;
    }

    //BLOQUE DE EJECUCIÓN
    @Override
    public void run() {
        //ECO INICIAL
        System.out.println(getName() + " INICIO");

        try {
            while (contador.getN() < N_WAIT) {
                this.sleep(TIEMPO);
                System.out.println(getName() + " espero. Contador: " + contador.getN());
            }
            System.out.println(getName() + " FIN");

        } catch (InterruptedException ex) {
            Logger.getLogger(Thread_2.class.getName()).log(Level.SEVERE, null, ex);

        }
    }

}

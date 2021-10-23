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
public class Thread_1 extends Thread {

    //CONSTANTES
    private static final int REPETICIONES = 50;
    private static final int TIEMPO = 500;

    //INSTANCIAMOS EL RC
    private Contador contador;

    public Thread_1(Contador contador) {
        this.contador = contador;
    }

    @Override
    public void run() {
        //ECO INICIAL
        System.out.println(getName() + " INICIO");
        for (int i = 0; i < REPETICIONES; i++) {

            try {
                //INCREMENTAMOS CONTADOR
                contador.setN(contador.getN() + 1);
                //ECO
                System.out.println(getName() + " contador: " + contador.getN());

                //SLEEP
                this.sleep(TIEMPO);
            } catch (InterruptedException ex) {
                Logger.getLogger(Thread_1.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        //ECO FINAL
        System.out.println(getName() + " FIN");
    }
}

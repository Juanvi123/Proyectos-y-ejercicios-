/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package intercambiador_testigo_v1;

import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author juanv
 */
public class Corredor2 extends Thread {

    //CONSTANTES
    private static final int TIEMPO_MIN = 1;
    private static final int TIEMPO_MAX = 100;

    //INSTANCIAMOS RC
    RC_Pto_Intercambio pto_Intercambio;

    //CONSTRUCTOR
    public Corredor2(RC_Pto_Intercambio pto_Intercambio) {
        this.pto_Intercambio = pto_Intercambio;
    }

    //BLOQUE DE EJECUCIÓN
    @Override
    public void run() {
        //SINCRONIZAMOS RC
        try {
            synchronized (pto_Intercambio) {
                //TIEMPO
                this.sleep(new Random().nextInt((TIEMPO_MAX - TIEMPO_MIN) + 1) + TIEMPO_MIN);

                //MIENTRAS SEMÁFORO ROJO, CORREDOR 2 SE ESPERA
                while (!pto_Intercambio.isSemaforo()) {
                    System.out.println(getName() + " espera");
                    pto_Intercambio.wait();

                }
                //CORREDOR 2 COJE EL TESTIGO
                System.out.println(getName() + " coge el testigo con valor "
                        + pto_Intercambio.getN());
                //NOTIFICAMOS 
                pto_Intercambio.notify();

            }
            //ECO FINAL
            System.out.println(getName() + " FIN");
        } catch (InterruptedException ex) {
            Logger.getLogger(Corredor2.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}

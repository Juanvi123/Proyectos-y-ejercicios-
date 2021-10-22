/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package intercambiador_testigo_v2;

import intercambiador_testigo_v1.*;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author juanv
 */
public class Corredor1 extends Thread {

    //CONSTANTES
    private static final int TIEMPO_MIN = 10;
    private static final int TIEMPO_MAX = 100;

    //INSTANCIAMOS RC
    RC_Pto_Intercambio pto_Intercambio;

    //CONSTRUCTOR
    public Corredor1(RC_Pto_Intercambio pto_Intercambio) {
        this.pto_Intercambio = pto_Intercambio;
    }

    @Override
    public void run() {
        //SINCRONIZAMOS 
        try {

            //TIEMPO
            this.sleep(new Random().nextInt((TIEMPO_MAX - TIEMPO_MIN) + 1) + TIEMPO_MIN);
         
            //INSTANCIA TESTIGO
            Testigo testigo = new Testigo();

            //PONEMOS TESTIGO EN RC
            pto_Intercambio.setN(testigo.getN());

            //CAMBIAMOS SEMAFORO
            pto_Intercambio.setSemaforo(true);

            //ECO
            System.out.println(getName() + " pone testigo con valor " + testigo.getN());
            System.err.println("Cambiamos semáforo a verde");

            //ECO FINAL
            System.out.println(getName() + " FIN");
        } catch (InterruptedException ex) {
            Logger.getLogger(Corredor1.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}

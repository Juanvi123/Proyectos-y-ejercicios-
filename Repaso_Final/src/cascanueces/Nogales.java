/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cascanueces;

import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author juanv
 */
public class Nogales extends Thread {

    //CONSTANTES
    private static final int N_MIN_NUECES = 50;
    private static final int N_MAX_NUECES = 150;
    private static final int TIEMPO_MIN = 100;
    private static final int TIEMPO_MAX = 350;
    //INSTANCIAMOS RC
    RC_Cesta cesta;
    //DEFINIMOS VARIABLES NUECES
    private int nNueces;

    //CONSTRUCTOR
    public Nogales(RC_Cesta cesta) {
        this.cesta = cesta;
        this.nNueces = new Random().nextInt((N_MAX_NUECES - N_MIN_NUECES) + 1) + N_MIN_NUECES;
    }

    //BLOQUE DE EJECUCIÓN
    @Override
    public void run() {
        try {
            //ECO INICIAL
            System.out.println(getName() + " tiene " + nNueces);

            for (int i = 0; i < nNueces; i++) {
                this.sleep(new Random().nextInt((TIEMPO_MAX - TIEMPO_MIN) + 1) + TIEMPO_MIN);
                //CREAMOS LA NUEZ
                Nueces nuez = new Nueces(i + 1, getName());
                //METEMOS NUEZ EN RC
                cesta.addNueces(nuez);
            }
            //ECO FINAL
            System.out.println(getName() + " FIN");
        } catch (InterruptedException ex) {
            Logger.getLogger(Nogales.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}

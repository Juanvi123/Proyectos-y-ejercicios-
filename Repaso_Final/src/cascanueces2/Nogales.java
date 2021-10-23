/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cascanueces2;

import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author juanv
 */
public class Nogales extends Thread {

    //CONSTANTES
    private static final int TIEMPO_MIN = 200;
    private static final int TIEMPO_MAX = 250;
    private static final int N_NUECES_MIN = 50;
    private static final int N_NUECES_MAX = 150;

    //DEFINIR CAMPOS NUEZ
    private int aleNueces;

    //INSTANCIAMOS RC
    RC_Cesta cesta;

    public Nogales(RC_Cesta cesta) {
        this.cesta = cesta;
        //INICIALIZAMOS ALEATORIAMENTE EL Nº DE NUECES QUE TENDRÁ CADA NOGAL
        this.aleNueces = new Random().nextInt((N_NUECES_MAX - N_NUECES_MIN) + 1) + N_NUECES_MIN;
    }

    //BLOQUE DE EJECUCIÓN
    @Override
    public void run() {
        try {
            //ECO INICIAL NOGALES
            System.out.println(getName() + " tiene " + aleNueces + " nueces");
            for (int i = 0; i < aleNueces; i++) {
                //TIEMPO ENTRE NUEZ Y NUEZ
                this.sleep(new Random().nextInt((TIEMPO_MAX - TIEMPO_MIN) + 1) + TIEMPO_MIN);
                //CREAMOS LA NUEZ
                Nuez nuez = new Nuez(i + 1, "nuez de " + getName());
                //METEMOS NUEZ EN RC
                cesta.addNuez(nuez);

            }
        } catch (InterruptedException ex) {
            Logger.getLogger(Nogales.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}

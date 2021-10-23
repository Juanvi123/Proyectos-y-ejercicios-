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
public class Cascanueces extends Thread {

    //CONSTANTES
    private static final int TIEMPO_MIN = 500;
    private static final int TIEMPO_MAX = 800;
    //INSTANCIAMOS RC
    RC_Cesta cesta;
    private int nNueces;

    //CONSTRUCTOR
    public Cascanueces(RC_Cesta cesta) {
        this.cesta = cesta;
        this.nNueces = 0;
    }

    //BLOQUE DE EJECUCIÓN
    @Override
    public void run() {
        while (!interrupted()) {
            try {
                //TIEMPO ENTRE COMIDA Y COMIDA
                this.sleep(new Random().nextInt((TIEMPO_MAX - TIEMPO_MIN) + 1) + TIEMPO_MIN);
                cesta.removeNueces();
                nNueces++;
            } catch (InterruptedException ex) {
                //ASI EVITAMOS BUCLES INFINITOS.
                getThreadGroup().interrupt();
                System.out.println(getName() + " FIN, se ha comido " + getnNueces() + " nueces");
            }
        }
    }
    //GETTER
    public int getnNueces() {
        return nNueces;
    }

}

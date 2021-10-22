/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pesebre_y_pollitos;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author juanv
 */
public class Pollitos extends Thread {

    //CONSTANTES
    private static final int PESO_MAX_POLLITO = 33;
    //INSTANCIAMOS RC
    RC_Pesebre pesebre;
    //VARIABLES
    private int peso;

    //CONSTRUCTOR
    public Pollitos(RC_Pesebre pesebre) {
        this.pesebre = pesebre;
        this.peso = 0;
    }

    //BLOQUE DE EJECUCIÓN
    @Override
    public void run() {
        while (peso < PESO_MAX_POLLITO) {
            try {
                this.sleep(500);

                peso += pesebre.removeGranos();
                System.err.println(getName() + " pesa " + peso);
            } catch (InterruptedException ex) {
                Logger.getLogger(Pollitos.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        System.out.println(getName() + " FIN. Ha alcanzado un peso de "+peso+"g");
    }

}

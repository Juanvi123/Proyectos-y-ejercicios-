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
public class Cascanueces extends Thread {

    //CONSTANTES
    private static final int TIEMPO_MIN = 500;
    private static final int TIEMPO_MAX = 1000;

    //INSTANCIAMOS RC
    RC_Cesta cesta;

    //VARIABLES
    private int contNueces;

    //BOOLEANO PARA CONTROLAR LA INTERRUPCION
    private boolean interrupt;

    //CONSTRUCTOR
    public Cascanueces(RC_Cesta cesta) {
        this.cesta = cesta;
        this.interrupt = false;
    }

    //BLOQUE DE EJECUCIÓN
    @Override
    public void run() {
        try {
            //COMO SERÁN DEMONIOS LOS ENCIERRO EN UN BUCLE INFINITO
            while (!interrupt) {
                //TIEMPO ENTRE CASCANUECES Y CASCANUECES
                this.sleep(new Random().nextInt((TIEMPO_MAX - TIEMPO_MIN) + 1) + TIEMPO_MIN);
                //CASCANUECES COGE NUEZ DE NOGAL
                cesta.removeNuez();
                //INCREMENTAMOS EL VALOR DEL CONTADOR
                contNueces++;
            }
        } catch (InterruptedException ex) {
            interrupt = true;
            while (cesta.getCount() != 0) {
                try {
                    //TIEMPO ENTRE CASCANUECES Y CASCANUECES
                    this.sleep(new Random().nextInt((TIEMPO_MAX - TIEMPO_MIN) + 1) + TIEMPO_MIN);
                    //CASCANUECES COGE NUEZ DE NOGAL
                    cesta.removeNuez();
                    //INCREMENTAMOS EL VALOR DEL CONTADOR
                    contNueces++;
                } catch (InterruptedException ex1) {
                   
                }
            }
            //ECO FINAL CASCANUECES
            System.out.println(getName() + " FIN,"
                    + "se ha comido: " + getContNueces() + " nueces");
            //EL PRIMER CASCACNUECES QUE ACABA INTERRUMPE AL RESTO PARA EVITAR BUCLES INFINITOS
            getThreadGroup().interrupt();
        }
    }

    //GETTER
    public int getContNueces() {
        return contNueces;
    }

}

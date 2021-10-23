/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package semaforo_coches;

import java.util.Random;

/**
 *
 * @author juanv
 */
public class RC_semaforo {

    //CONSTANTES
    private static final int N_MIN = 1;
    //VARIABLES
    private int n;
    private int nCoches;

    public RC_semaforo(int nCoches) {
        this.n = new Random().nextInt((nCoches - N_MIN) + 1) + N_MIN;
        this.nCoches=nCoches;
        System.out.println("valor inicial semaforo: "+n);
    }

    public int getN() {
        return n;
    }

    public void setN() throws InterruptedException {
       
        if (n <nCoches) {
            n++;
        } else {
            this.n = 1;
        }
        System.out.println("Semaforo vale "+n);
       
    }

}

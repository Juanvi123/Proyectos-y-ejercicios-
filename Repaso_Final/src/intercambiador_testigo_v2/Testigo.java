/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package intercambiador_testigo_v2;

import java.util.Random;

/**
 *
 * @author juanv
 */
public class Testigo {
    //CONSTANTES
    private static final int N_MIN=1;
    private static final int N_MAX=10;
    
    //DECLARAMOS VARIABLES
    private int n;

    //CONSTRUCTOR
    public Testigo() {
        //INICIALIZAMOS EL TESTIGO ALEATORIAMENTE
        this.n=new Random().nextInt((N_MAX-N_MIN)+1)+N_MIN;
    }

    //GETTERS Y SETTERS
    public int getN() {
        return n;
    }

    public void setN(int n) {
        this.n = n;
    }
    
}

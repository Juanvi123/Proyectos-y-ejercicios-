/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pollitos_y_pesebre_v2;

import pesebre_y_pollitos.*;
import java.util.Random;

/**
 *
 * @author juanv
 */
public class Granos {
    //CONSTANTES
    private static final int N_MIN=1;
    private static final int N_MAX=15;
    //DECLARAMOS VARIABLES
    private int n;

    //CONSTRUCTOR
    public Granos() {
        //INICIALIZAMOS ALEATORIAMENTE EL GRANO
        this.n=new Random().nextInt((N_MAX-N_MIN)+1)+N_MIN;
    }

    public int getN() {
        return n;
    }
    
}

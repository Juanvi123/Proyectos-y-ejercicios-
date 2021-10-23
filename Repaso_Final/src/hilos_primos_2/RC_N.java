/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hilos_primos_2;

import java.util.List;
import java.util.Random;

/**
 *
 * @author juanv
 */
public class RC_N {

    //CONSTANTES
    private static final int N_MIN = 1;
    private static final int N_MAX = 10;
    
    //CONTENEDOR
    //List<Object>
    
    //DECLARAMOS VARIABLES 
    private int n;

    //CONSTRUCTOR
    public RC_N() {
        this.n=new Random().nextInt((N_MAX-N_MIN)+1)+N_MIN;
        System.out.println("valor inicial del nº del RC: "+n);
    }

    //GETTERS Y SETTERS
    public int getN() {
        return n;
    }
    

    public void setN(int n) {
        this.n = n;
    }
    
    

}

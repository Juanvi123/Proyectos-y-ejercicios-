/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hilos_primos;

import java.util.Random;

/**
 *
 * @author juanv
 */
public class Numeros {

    //CONSTANTES
    private static final int N_MIN = 1;
    private static final int N_MAX = 100;
    //DECLARAMOS VARIABLE
    private int n;

    //CONSTRUCTOR
    public Numeros() {
        //INICALIZAMOS EL Nº ALEATORIAMENTE
        this.n = new Random().nextInt((N_MAX-N_MIN)+1)+N_MIN;
    }
    
    //GETTERS Y SETTERS
    public int getN() {
        return n;
    }

    public void setN(int n) {
        this.n = n;
    }
    

}

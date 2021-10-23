/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hilos_bolas;

/**
 *
 * @author juanv
 */
public class Bola {

    //DECLARAMOS VARIABLES
    private int cont;
    private int acumulador;

    //CONSTRUCTOR
    public Bola(int cont, int acumulador) {
        this.cont = cont;
        this.acumulador = acumulador;
    }

    //GETTERS Y SETTERS
    public int getCont() {
        return cont;
    }

    public void setCont(int cont) {
        this.cont = cont;
    }

    public int getAcumulador() {
        return acumulador;
    }

    public void setAcumulador(int acumulador) {
        this.acumulador = acumulador;
    }

}

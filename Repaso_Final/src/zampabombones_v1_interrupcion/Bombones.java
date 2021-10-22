/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zampabombones_v1_interrupcion;

/**
 *
 * @author juanv
 */
public class Bombones {
    //DECLARAMOS VARIABLES
    private int n;
    private String sabor;

    //CONSTRUCTOR
    public Bombones(int n, String sabor) {
        this.n = n;
        this.sabor = sabor;
    }

    //GETTERS Y SETTERS
    public int getN() {
        return n;
    }

    public void setN(int n) {
        this.n = n;
    }

    public String getSabor() {
        return sabor;
    }

    public void setSabor(String sabor) {
        this.sabor = sabor;
    }
    
}

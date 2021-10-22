/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cascanueces2;

/**
 *
 * @author juanv
 */
public class Nuez {
    //DECLARAR VARIABLES
    private int n;
    private String nombreNuez;

    //CONSTRUCTOR
    public Nuez(int n, String nombreNuez) {
        this.n = n;
        this.nombreNuez = nombreNuez;
    }

    //GETTERS Y SETTERS
    public int getN() {
        return n;
    }

    public void setN(int n) {
        this.n = n;
    }

    public String getNombreNuez() {
        return nombreNuez;
    }

    public void setNombreNuez(String nombreNuez) {
        this.nombreNuez = nombreNuez;
    }
    
    
}

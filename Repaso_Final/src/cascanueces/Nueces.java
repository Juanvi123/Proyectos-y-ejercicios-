/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cascanueces;

/**
 *
 * @author juanv
 */
public class Nueces {

    //DECLARAMOS VARIABLES
    private int n;
    private String nombreNogal;

    //CONSTRUCTOR
    public Nueces(int n, String nombreNogal) {
        this.n = n;
        this.nombreNogal = nombreNogal;
    }

    //GETTERS
    public int getN() {
        return n;
    }

    public String getNombreNogal() {
        return nombreNogal;
    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gallinas_y_buitres;

/**
 *
 * @author juanv
 */
public class Huevo {

    //DECLARAMOS VARIABLES
    private String nombreAnimal;
    private int peso;

    //CONSTRUCTOR
    public Huevo(String nombreAnimal, int peso) {
        this.nombreAnimal = nombreAnimal;
        this.peso = peso;
    }
    //GETTERS Y SETTERS

    public String getNombreAnimal() {
        return nombreAnimal;
    }

    public void setNombreAnimal(String nombreAnimal) {
        this.nombreAnimal = nombreAnimal;
    }

    public int getPeso() {
        return peso;
    }

    public void setPeso(int peso) {
        this.peso = peso;
    }

}

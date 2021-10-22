/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cafeteria;

/**
 *
 * @author juanv
 */
public class Bocadillos {
    //DECLARAMOS VARIABLES
    private String nombreBocata;
    private double precio;

    //CONSTRUCTOR
    public Bocadillos(String nombreBocata, double precio) {
        this.nombreBocata = nombreBocata;
        this.precio = precio;
    }

    //GETTERS Y SETTERS
    public String getNombreBocata() {
        return nombreBocata;
    }

    public void setNombreBocata(String nombreBocata) {
        this.nombreBocata = nombreBocata;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }
    
}

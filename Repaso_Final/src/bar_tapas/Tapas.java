/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bar_tapas;

/**
 *
 * @author juanv
 */
public class Tapas {
    
    //DECLARAMOS VARIABLES 
    private String nombre;
    private double precio;

    //CONSTRUCTOR
    public Tapas(String nombre, double precio) {
        this.nombre = nombre;
        this.precio = precio;
    }

    //GETTERS Y SETTERS
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

}

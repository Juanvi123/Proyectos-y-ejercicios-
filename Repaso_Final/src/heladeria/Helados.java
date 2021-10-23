/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package heladeria;

/**
 *
 * @author juanv
 */
public class Helados {

    //DECLARAMOS VARIABLES
    private String sabor;
    private double precio;

    //CONSTRUCTOR
    public Helados(String sabor, double precio) {
        this.sabor = sabor;
        this.precio = precio;
    }

    //GETTERS Y SETTERS
    public String getSabor() {
        return sabor;
    }

    public void setSabor(String sabor) {
        this.sabor = sabor;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }
    
    

}

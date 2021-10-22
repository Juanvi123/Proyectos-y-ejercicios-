/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package supermercado_v3_varios_reponedores_cero_articulos;

/**
 *
 * @author juanv
 */
public class Articulos {
    //DECLARAMOS VARIABLES
    private String nombre;
    private double precio;

    //CONSTRUCTOR
    public Articulos(String nombre, double precio) {
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

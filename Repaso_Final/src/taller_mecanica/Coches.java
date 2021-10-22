/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package taller_mecanica;

/**
 *
 * @author juanv
 */
public class Coches {
    //DECLARAMOS VARIABLES
    private String nombre;
    private double costeReparacion;

    //CONSTRUCTOR
    public Coches(String nombre) {
        this.nombre = nombre;
        this.costeReparacion=0;
    }
    
    //GETTERS Y SETTERS
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getCosteReparacion() {
        return costeReparacion;
    }

    public void setCosteReparacion(double costeReparacion) {
        this.costeReparacion = costeReparacion;
    }
}

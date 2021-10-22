/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package package21_Juan_Vicente_02e14_FabricaPan;

/**
 *
 * @author juanv
 */
public class Alimentos {
    //DECLARAMOS VARIABLES
    private String nombre;
    private String descripcion;
    private double precio;

    //CONSTRUCTOR POR DEFECTO
    public Alimentos() {
    }
    //CONSTRUCTOR CON TODOS LOS PARAMETROS
    public Alimentos(String nombre, String descripcion, double precio) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
    }
    
    //GETTERS Y SETTERS
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    @Override
    public String toString() {
        return this.nombre+" "+this.precio+"€";
    }
    
    
}

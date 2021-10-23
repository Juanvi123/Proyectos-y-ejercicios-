/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tuercas_y_tornillos;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author juanv
 */
public class Blisters {
    //CONSTANTES
    public final int N_MAX_BLISTERS=100;
    //DECLARAMOS VARIABLES
    private String etiqueta;
    private double precio;
    private double [] tamano=new double[2];
    private List lstElementos;

    //CONSTRUCTOR
    public Blisters(String etiqueta, double precio, double[] tamano) {
        this.etiqueta = etiqueta;
        this.precio = precio;
        this.tamano = tamano;
        this.lstElementos=new ArrayList();
    }
    
    //GETTERS Y SETTERS
    public String getEtiqueta() {
        return etiqueta;
    }

    public void setEtiqueta(String etiqueta) {
        this.etiqueta = etiqueta;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public double[] getTamano() {
        return tamano;
    }

    public void setTamano(double[] tamano) {
        this.tamano = tamano;
    }
    
    //MÉTODO PARA ANADIR TUERCAS O TORNILLOS
    
    public void addTuerca(Tuercas tuerca){
        this.lstElementos.add(tuerca);
    }
    
    public void addTornillo(Tornillos tornillo){
        this.lstElementos.add(tornillo);
    }
    
    public int getCountBlister(){
        return lstElementos.size();
    }
    
    
}

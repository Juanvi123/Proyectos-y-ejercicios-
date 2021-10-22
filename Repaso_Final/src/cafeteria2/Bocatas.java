/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cafeteria2;

/**
 *
 * @author juanv
 */
public class Bocatas {

    //DECLARAMOS VARIABLES
    private String nombreBocata;
    private double precioBocata;

    //CONSTRUCTOR
    public Bocatas(String nombreBocata, double precioBocata) {
        this.nombreBocata = nombreBocata;
        this.precioBocata = precioBocata;
    }

    //GETTERS Y SETTERS
    public String getNombreBocata() {
        return nombreBocata;
    }

    public void setNombreBocata(String nombreBocata) {
        this.nombreBocata = nombreBocata;
    }

    public double getPrecioBocata() {
        return precioBocata;
    }

    public void setPrecioBocata(double precioBocata) {
        this.precioBocata = precioBocata;
    }
    
    
}

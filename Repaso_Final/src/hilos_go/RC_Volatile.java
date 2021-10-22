/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hilos_go;

/**
 *
 * @author juanv
 */
public class RC_Volatile {
    //CREAMOS VARIABLE VOLATIL
    private volatile String variableVolatil;

    //CONSTRUCTOR
    public RC_Volatile() {
        //LA INICIALIZAMOS EN STOP
        this.variableVolatil="stop";
    }

    //GETTERS Y SETTERS
    public String getVariableVolatil() {
        return variableVolatil;
    }

    public void setVariableVolatil(String variableVolatil) {
        this.variableVolatil = variableVolatil;
    }
    
    
}

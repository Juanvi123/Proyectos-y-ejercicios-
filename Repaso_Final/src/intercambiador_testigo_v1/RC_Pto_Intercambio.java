/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package intercambiador_testigo_v1;

/**
 *
 * @author juanv
 */
public class RC_Pto_Intercambio {
    //SEMAFORO
    private boolean semaforo; //TRUE verde FALSE rojo
    //Nº
    private int n;

    //CONSTRUCTOR
    public RC_Pto_Intercambio() {
        //INICIALMENTE EL SEMÁFORO ESTÁ ROJO
        this.semaforo=false;
        this.n=0;
    }
   
   //GETTERS Y SETTERS
    public boolean isSemaforo() {
        return semaforo;
    }

    public void setSemaforo(boolean semaforo) {
        this.semaforo = semaforo;
    }

    public int getN() {
        return n;
    }

    public void setN(int n) {
        this.n = n;
    }
    
}

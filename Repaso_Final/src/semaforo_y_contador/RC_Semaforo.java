/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package semaforo_y_contador;

/**
 *
 * @author juanv
 */
public class RC_Semaforo {
    private boolean semaforo;//TRUE VERDE, FALSE ROJO

    //CONSTRUCTOR
    public RC_Semaforo() {
        //INICIALMENTE SEMAFORO ROJO
        this.semaforo=false;
    }
    
    //GETTERS Y SETTERS

    public boolean isSemaforo() {
        return semaforo;
    }

    public void setSemaforo(boolean semaforo) {
        this.semaforo = semaforo;
    }
    
}

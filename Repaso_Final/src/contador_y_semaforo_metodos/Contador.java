/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package contador_y_semaforo_metodos;

/**
 *
 * @author juanv
 */
public class Contador {
    //DECLARAMOS VARIABLES
    private int n;

    //CONTADOR
    public Contador(int n) {
        this.n = n;
    }

    //GETTERS Y SETTERS
    public int getN() {
        return n;
    }

    public synchronized void setN(int n) {
        this.n = n;
    }
    
}

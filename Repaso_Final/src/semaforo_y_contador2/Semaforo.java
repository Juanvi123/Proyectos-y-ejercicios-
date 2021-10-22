/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package semaforo_y_contador2;

/**
 *
 * @author juanv
 */
public class Semaforo {

    //DECLARAMOS VARIABLE
    private boolean semaforo;//true VERDE, false ROJO

    //CONSTRUCTOR
    public Semaforo() {
        this.semaforo = false;
    }

    //GETTERS Y SETTERS
    public boolean isSemaforo() {
        return semaforo;
    }

    public void setSemaforo() {
        if (isSemaforo()) {
            this.semaforo = false;
            System.err.println(Thread.currentThread().getName() + " "
                    + "cambia semáforo a rojo");
        } else {
            this.semaforo = true;
            System.err.println(Thread.currentThread().getName() + " "
                    + "cambia semáforo a verde");
        }
    }

}

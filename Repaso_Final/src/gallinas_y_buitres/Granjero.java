/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gallinas_y_buitres;

/**
 *
 * @author juanv
 */
public class Granjero extends Thread {
    //INSTANCIAMOS RC
    RC_Huevera huevera;

    //CONSTRUCTOR
    public Granjero(RC_Huevera huevera) {
        this.huevera = huevera;
    }

    //BLOQUE DE EJECUCIÓN
    @Override
    public void run() {
       //INTERRUMPE A TODOS LOS HILOS
        System.out.println(getName()+" me he despertado");
        getThreadGroup().interrupt();
    }
    
}

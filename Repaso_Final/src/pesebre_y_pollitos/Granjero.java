/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pesebre_y_pollitos;

import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author juanv
 */
public class Granjero extends Thread {
    //CONSTANTES

    //INSTANCIAMOS RC
    RC_Pesebre pesebre;

    //CONSTRUCTOR
    public Granjero(RC_Pesebre pesebre) {
        this.pesebre = pesebre;
    }

    @Override
    public void run() {
        while(true){
            try {
                //CREAMOS EL GRANO
                Granos grano=new Granos();
                pesebre.addGrano(grano);
            } catch (InterruptedException ex) {
                Logger.getLogger(Granjero.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
    }
    
}

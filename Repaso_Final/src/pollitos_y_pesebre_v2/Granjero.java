/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pollitos_y_pesebre_v2;

import java.util.List;
import pesebre_y_pollitos.*;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author juanv
 */
public class Granjero extends Thread {
    //CONSTANTES
    private static final int MAXIMO_PESO_POLLITOS=33;
    private static final int N_POLLITOS=10;
    //INSTANCIAMOS RC
    RC_Pesebre pesebre;
    List<Pollitos> lstPollitos;

    //CONSTRUCTOR
    //LE PASAMOS LA LIST CON LOS HILOS CREADOS EN EL MAIN DE POLLITOS
    public Granjero(RC_Pesebre pesebre, List<Pollitos> lstPollitos) {
        this.pesebre = pesebre;
        this.lstPollitos=lstPollitos;
    }

    @Override
    public void run() {
        while (true) {
            try {
                //CREAMOS EL GRANO
                Granos grano = new Granos();
                pesebre.addGrano(grano);
                for(int i=0;i<N_POLLITOS;i++){
                    //CUANDO UNO DE ESOS POLLITOS ALCANZA UN PESO SUPERIOR A 33
                    //LO INTERRUMPIMOS
                    if(lstPollitos.get(i).getPeso()>=MAXIMO_PESO_POLLITOS){
                        lstPollitos.get(i).interrupt();
                    }
                }
            } catch (InterruptedException ex) {
                Logger.getLogger(Granjero.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }

}

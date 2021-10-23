/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package secretaria_ies;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author juanv
 */
public class Administrativas extends Thread{
    //INSTANCIAMOS RC
    RC_Despacho despacho;
    
    //BOOLEANO CONTROLAR LA INTERRUPCIÓN
    private boolean interrupt;
    
    //CONSTRUCTOR
    public Administrativas(RC_Despacho despacho) {
        this.despacho = despacho;
        this.interrupt=false;
    }
    
    //BLOQUE DE EJECUCIÓN
    @Override
    public void run() {
        while(!interrupt){
            try {
                this.sleep(500);
                despacho.comprobarBandeja();
            } catch (InterruptedException ex) {
                interrupt=true;
                while(despacho.getCount()!=0){
                    try {
                        despacho.marcarBandejaLlena();
                        this.sleep(500);
                        despacho.comprobarBandeja();
                    } catch (InterruptedException ex1) {
                        System.out.println(getName()+" FIN");
                    }
                }
                System.out.println(getName()+" vacía la bandeja, "+despacho.getRecaudado());
                getThreadGroup().interrupt();
                break;
            }
        }
    }
    
    
}

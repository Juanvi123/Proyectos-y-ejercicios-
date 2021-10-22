/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cafeteria;

import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author juanv
 */
public class Clientes extends Thread{
    //CONSTANTES
     private static final int TIEMPO_MIN = 1000;
    private static final int TIEMPO_MAX = 1500;
    //INSTANCIAMOS EL RC
    RC_Bandeja bandeja;

    //CONSTRUCTOR
    public Clientes(RC_Bandeja bandeja) {
        this.bandeja = bandeja;
    }

    //BLOQUE DE EJECUCIÓN
    @Override
    public void run() {
         try {
             //TIEMPO ENTRE VENTA Y VENTA
             this.sleep(new Random().nextInt((TIEMPO_MAX-TIEMPO_MIN)+1)+TIEMPO_MIN);
             Bocadillos bocadillo=bandeja.removeBocata();
             bandeja.pagarBocata(bocadillo);
             System.out.println(getName()+" FIN");
         } catch (InterruptedException ex) {
             Logger.getLogger(Clientes.class.getName()).log(Level.SEVERE, null, ex);
         }
    }
    
    
    
}

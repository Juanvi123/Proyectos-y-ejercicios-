/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cafeteria2;

import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author juanv
 */
public class Clientes extends Thread {
    
    //CONSTANTES
    private static final int TIEMPO_MIN = 500;
    private static final int TIEMPO_MAX = 1000;
    private static final int TIEMPO_PAGAR_MIN = 5;
    private static final int TIEMPO_PAGAR_MAX = 10;
    
    //INSTANCIAMOS RC
    RC_Bandeja bandeja;

    //CONSTRUCTOR
    public Clientes(RC_Bandeja bandeja) {
        this.bandeja = bandeja;
    }

    //BLOQUE DE EJECUCIÓN
    @Override
    public void run() {
        try {
            //TIEMPO ENTRE CLIENTES
            this.sleep(new Random().nextInt((TIEMPO_MAX - TIEMPO_MIN) + 1) + TIEMPO_MIN);
            //CLIENTE COGE BOCATA
            Bocatas bocata= bandeja.removerBocata();
            //TIEMPO PARA PAGAR
            this.sleep(new Random().nextInt((TIEMPO_PAGAR_MAX - TIEMPO_PAGAR_MIN) + 1) + TIEMPO_PAGAR_MIN);
            //CLIENTE PAGA BOCATA
            bandeja.pagarBocata(bocata);
            //ECO FINAL CLIENTE
            System.out.println(getName()+" FIN");
        } catch (InterruptedException ex) {
            Logger.getLogger(Clientes.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    
}

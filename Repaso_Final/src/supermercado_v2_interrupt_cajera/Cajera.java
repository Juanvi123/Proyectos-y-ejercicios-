/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package supermercado_v2_interrupt_cajera;

import supermercado_1_cliente.*;
import java.util.List;

/**
 *
 * @author juanv
 */
public class Cajera extends Thread {
    //INTANCIAMOS RC
    RC_Estanteria estanteria;

    //CONSTRUCTOR
    public Cajera(RC_Estanteria estanteria) {
        this.estanteria = estanteria;
    }

    //BLOQUE DE EJECUCIÓN
    @Override
    public void run() {
        //INTERRUMPE A TODOS
        getThreadGroup().interrupt();
        System.out.println(getName()+" hace una recaudación de "+
                String.format("%.2f", estanteria.getRecaudacion())+"€");
        System.out.println(getName()+" FIN");
    }
    
}

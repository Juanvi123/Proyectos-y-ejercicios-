/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package supermercado_v2_interrupt_cajera;

import supermercado_1_cliente.*;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author juanv
 */
public class Clientes extends Thread {

    //CONSTANTES
    private static final int TIEMPO_MIN = 1000;
    private static final int TIEMPO_MAX = 1500;
    //INSTANCIAMOS RC
    RC_Estanteria estanteria;
    //VARIABLES
    private int precio;

    //BOOLEANO CONTROLAR INTERRUPCION
    private boolean interrupt;

    //CONSTRUCTOR
    public Clientes(RC_Estanteria estanteria) {
        this.estanteria = estanteria;
        this.interrupt = false;
    }

    //BLOQUE DE EJECUCIÓN
    @Override
    public void run() {
        try {
            while (!interrupt) {
                //TIEMPO ENTRE CLIENTES
                this.sleep(new Random().nextInt((TIEMPO_MAX - TIEMPO_MIN) + 1) + TIEMPO_MIN);
                Articulos articulo = estanteria.removeArticulos();
                estanteria.pagarCajera(articulo);
            }
        } catch (InterruptedException ex) {
            interrupt=true;
            System.out.println("Cajera echa a "+getName());
        }
    }

}

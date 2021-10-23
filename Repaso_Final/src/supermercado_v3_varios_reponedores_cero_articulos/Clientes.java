/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package supermercado_v3_varios_reponedores_cero_articulos;

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
    private double precio;
    private int nArticulos;

    //BOOLEANO CONTROLAR INTERRUPCION
    private boolean interrupt;

    //CONSTRUCTOR
    public Clientes(RC_Estanteria estanteria) {
        this.estanteria = estanteria;
        this.interrupt = false;
        this.precio = 0;
        this.nArticulos = 0;
    }

    //BLOQUE DE EJECUCIÓN
    @Override
    public void run() {
        try {
            while (!interrupt) {
                //TIEMPO ENTRE CLIENTES
                this.sleep(new Random().nextInt((TIEMPO_MAX - TIEMPO_MIN) + 1) + TIEMPO_MIN);
                Articulos articulo = estanteria.removeArticulos();
                //INCREMENTAMOS EL CONTADOR DE ARTÍCULOS DEL CLIENTE
                nArticulos++;
                //ACUMULAMOS LO GASTADO POR EL CLIENTE
                precio += articulo.getPrecio();
                estanteria.pagarCajera(articulo);
            }
        } catch (InterruptedException ex) {
            interrupt = true;
            while (estanteria.getCount() != 0) {
                try {
                    Articulos articulo = estanteria.removeArticulos();
                    //INCREMENTAMOS EL CONTADOR DE ARTÍCULOS DEL CLIENTE
                    nArticulos++;
                    //ACUMULAMOS LO GASTADO POR EL CLIENTE
                    precio += articulo.getPrecio();
                    estanteria.pagarCajera(articulo);
                } catch (InterruptedException ex1) {
                    Logger.getLogger(Clientes.class.getName()).log(Level.SEVERE, null, ex1);
                }
            }
            System.out.println(getName() + " FIN, se ha llevado " + nArticulos + " y se ha gastado "
                    + String.format("%.2f", precio) + "€");
        }
    }

}

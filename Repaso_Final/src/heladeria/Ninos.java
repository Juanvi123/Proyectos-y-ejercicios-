/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package heladeria;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author juanv
 */
public class Ninos extends Thread {
    //CONSTANTES
    private static final int TIEMPO = 1000;
    //INSTANCIAMOS RC
    RC_Nevera nevera;

    //VARIABLES
    private double precio;
    private int contHelados;
    //BOOLEANO PARA CONTROLAR LA INTERRUPCIÓN
    private boolean interrupt;

    //CONSTRUCTOR
    public Ninos(RC_Nevera nevera) {
        this.nevera = nevera;
        this.contHelados = 0;
        this.precio = 0.0;
        this.interrupt = false;
    }

    //BLOQUE DE EJECUCIÓN
    @Override
    public void run() {

        try {
            while (!interrupt) {
                //TIEMPO ENTRE HELADO Y HELADO QUE SE COMPRA
                this.sleep(TIEMPO);
                Helados helado = nevera.removeHelado();
                //INCREMENTAMOS EL CONTADOR DE HELADOS COMIDOS POR EL NIÑO
                contHelados++;
                //ACUMULAMOS PASTA QUE SE HA GASTADO EL NIÑO
                precio += helado.getPrecio();
            }
        } catch (InterruptedException ex) {
            interrupt = true;
            while (nevera.getCount() != 0) {
                try {
                   Helados helado = nevera.removeHelado();
                    //INCREMENTAMOS EL CONTADOR DE HELADOS COMIDOS POR EL NIÑO
                    contHelados++;
                    //ACUMULAMOS PASTA QUE SE HA GASTADO EL NIÑO
                    precio += helado.getPrecio();
                } catch (InterruptedException ex1) {
                    Logger.getLogger(Ninos.class.getName()).log(Level.SEVERE, null, ex1);
                }
            }
            System.out.println(getName()+" FIN, se ha comido "+contHelados+" helados,"
                    + " se ha gastado: "+String.format("%.2f", precio)+"€");
        }
    }

}

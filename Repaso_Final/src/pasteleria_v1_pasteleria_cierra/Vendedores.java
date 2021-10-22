/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pasteleria_v1_pasteleria_cierra;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author juanv
 */
public class Vendedores extends Thread {
    //CONSTANTES
    private static final int TIEMPO_MIN=500;
    private static final int TIEMPO_MAX=1000;
    //INSTANCIAMOS RC
    RC_Pila pila;
    //BOOLEANO PARA CONTROLAR LA INTERRUPCIÓN
    private boolean interrupt;
    //RECAUDADO POR CADA VENDEDOR
    private double precio;

    //CONSTRUCTOR
    public Vendedores(RC_Pila pila) {
        this.pila = pila;
        this.interrupt=false;
        this.precio=0.0;
    }

    //BLOQUE DE EJECUCIÓN
    @Override
    public void run() {
        while(!interrupt){
            try {
                //TIEMPO ENTRE VENTA Y VENTA
                this.sleep(new Random().nextInt((TIEMPO_MAX-TIEMPO_MIN)+1)+TIEMPO_MIN);
               List<Dulces>lstDulces= pila.removeBandeja();
                for(Dulces dulce: lstDulces){
                    precio+=dulce.getPrecio();
                }
           
            } catch (InterruptedException ex) {
                interrupt=true;
                System.out.println(getName()+" FIN, dinero recaudado por "+getName()+": "+
                        String.format("%.2f", precio)+"€");
            }
        }
    }
    
    //GETTER
    public double getPrecio() {
        return precio;
    }
    
    
}

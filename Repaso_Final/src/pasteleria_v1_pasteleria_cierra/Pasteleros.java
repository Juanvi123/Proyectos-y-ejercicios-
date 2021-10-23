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
public class Pasteleros extends Thread {

    //CONSTANTES
    private static final int TIEMPO_DULCE = 6;
    private static final int TIEMPO_MIN = 250;
    private static final int TIEMPO_MAX = 500;
    private static final int CAPACIDAD_BANDEJA = 6;
    private static final double PRECIO_MIN = 0.75;
    private static final double PRECIO_MAX = 4.25;

    //INSTANCIAMOS RC
    RC_Pila pila;

    //CONTENEDOR DE DULCES
    List<Dulces> lstBandeja;

    //CONTADOR DULCES
    private int cont;

    //BOOLEANO PARA CONTROLAR INTERRUPCIÓN
    private boolean interrupt;

    //CONSTRUCTOR
    public Pasteleros(RC_Pila pila) {
        this.pila = pila;
        this.lstBandeja = new ArrayList<>();
        this.interrupt = false;
        this.cont = 0;
    }

    //BLOQUE DE EJECUCIÓN
    @Override
    public void run() {
        while (!interrupt) {
            try {
                //MIENTRAS NO LLENEMOS BANDEJA, PASTELERO HACE DULCES
                while (lstBandeja.size() < CAPACIDAD_BANDEJA) {
                    //TIEMPO ENTRE DULCE Y DULCE
                    this.sleep(TIEMPO_DULCE);
                    //CREAMOS DULCE
                    cont++;
                    Dulces dulce = new Dulces("Dulce " + cont + " de " + getName(),
                            Math.random() * (PRECIO_MAX) + PRECIO_MIN);
                    //METEMOS DULCE EN BANDEJA
                    lstBandeja.add(dulce);
                }
                //TIEMPO LLENADO BANDEJA
                this.sleep(new Random().nextInt((TIEMPO_MAX-TIEMPO_MIN)+1)+TIEMPO_MIN);
                //METEMOS BANDEJA EN RC
                pila.addBandeja(lstBandeja);
                //VOLVEMOS A INICIALIZAR LA BANDEJA
                lstBandeja=new ArrayList<>();
            } catch (InterruptedException ex) {
                interrupt = true;
                System.out.println(getName() + " FIN");
            }
        }
    }

}

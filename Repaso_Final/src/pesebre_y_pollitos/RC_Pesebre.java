/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pesebre_y_pollitos;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 *
 * @author juanv
 */
public class RC_Pesebre {

    //CONSTANTES
    private static final int TAMANO_PESEBRE = 100;
    private static final int TIEMPO_MIN = 1000;
    private static final int TIEMPO_MAN = 4000;
    //CONTENEDOR
    List<Granos> lstGranos;

    //CONSTRUCTOR
    public RC_Pesebre() {
        this.lstGranos = new ArrayList<>();
    }

    public synchronized void addGrano(Granos grano) throws InterruptedException {
        while (getCount() == TAMANO_PESEBRE) {
            wait();
        }
        //AÑADIMOS GRANO
        lstGranos.add(grano);
        //NOTIFICAMOS 
        notifyAll();
        if (getCount() == TAMANO_PESEBRE) {
            System.out.println("El " + Thread.currentThread().getName() + " ha llenado el pesebre");
            notifyAll();
            //TIEMPO DE ESPERA CUANDO HA LLENADO EL PESEBRE
            Thread.sleep(new Random().nextInt((TIEMPO_MAN-TIEMPO_MIN)+1)+TIEMPO_MIN);
        }

    }

    public synchronized int removeGranos() throws InterruptedException {
        while (getCount() == 0) {
            wait();
        }
        int alea = new Random().nextInt(lstGranos.size());
        Granos grano = lstGranos.get(alea);
        lstGranos.remove(grano);
        System.out.println(Thread.currentThread().getName() + " come grano con peso de "
                + grano.getN() + "g");
        notifyAll();
        if (getCount() == 0) {
            System.out.println("El pesebre se ha vaciado");
            notifyAll();
        }
        return grano.getN();
    }

    public int getCount() {
        return lstGranos.size();
    }
}

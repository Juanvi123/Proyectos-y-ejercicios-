/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pasteleria_v1_pasteleria_cierra;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 *
 * @author juanv
 */
public class RC_Pila {

    //CONSTANTES
    private static final int CAPACIDAD_PILA = 6;
    //CONTENEDOR
    private List<List<Dulces>> lstPilaBandejas;

    //CONSTRUCTOR
    public RC_Pila() {
        this.lstPilaBandejas = new ArrayList<>();
    }

    //MÉTODOS
    public synchronized void addBandeja(List<Dulces> bandeja) throws InterruptedException {
        //MIENTRAS LA BANDEJA ESTÁ LLENA, LOS PASTELEROS PARAN
        while (getCount() == CAPACIDAD_PILA) {
            wait();
        }
        //AÑADIMOS BANDEJA A LA PILA
        lstPilaBandejas.add(bandeja);
        //ECOS
        System.out.println(Thread.currentThread().getName() + " ha añadido una bandeja");
        System.err.println("La pila tiene " + getCount() + " bandejas");
        //NOTIFICAMOS A TODOS 
        notifyAll();
        //ECO BANDEJA LLENA
        if (getCount() == CAPACIDAD_PILA) {
            System.out.println("La bandeja se ha llenado");
            notifyAll();
        }
    }

    public int getCount() {
        return lstPilaBandejas.size();
    }

    public synchronized List<Dulces> removeBandeja() throws InterruptedException {
        //MIENTRAS NO HAYA BANDEJAS EN LA PILA, LOS VENDEDORES PARAN
        while (getCount() == 0) {
            wait();
        }
        //QUITAMOS ALEATORIAMENTE UNA BANDEJA
        int aleatorio = new Random().nextInt(getCount());
        List<Dulces> lstDulces = lstPilaBandejas.get(aleatorio);
        lstPilaBandejas.remove(lstDulces);
        //DESGLOSAMOS LOS DULCES
        for (Dulces dulce : lstDulces) {
            System.out.println(Thread.currentThread().getName() + " vende " + dulce.getNombre() + " con precio de "
                    + String.format("%.2f", dulce.getPrecio()) + "€");
        }
        System.out.println("La pila tiene " +getCount() + " bandejas");

        return lstDulces;
    }

}

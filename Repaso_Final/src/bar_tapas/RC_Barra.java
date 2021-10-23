/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bar_tapas;

import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.List;
import java.util.Random;

/**
 *
 * @author juanv
 */
public class RC_Barra {

    //CONSTANTES
    private static final int CAPACIDAD_BANDEJAS = 3;
    private static final int CAPACIDAD_BEBIDAS = 24;

    //CONTENEDORES
    private List<List<Tapas>> lstBandejas;
    private List<Bebidas> lstBebidas;

    //CONSTRUCTOR
    public RC_Barra() {
        //INICIALIZAMOS CONTENEDORES
        this.lstBandejas = new ArrayList<>();
        this.lstBebidas = new ArrayList<>();
    }

    /**
     * Método para añadir bandejas a la barra
     *
     * @param bandeja objeto bandeja que añade el cocinero a la barra
     * @throws InterruptedException
     */
    public synchronized void addBandeja(List<Tapas> bandeja) throws InterruptedException {
        //MIENTRAS SE LLEGUE A LA CAPACIDAD DE BANDEJAS, ESPERAN
        while (getCountBandejas() == CAPACIDAD_BANDEJAS) {
            wait();
        }
        //AÑADIMOS BANDEJA A LA BARRA
        lstBandejas.add(bandeja);
        //ECOS
        System.out.println(Thread.currentThread().getName() + " pone bandeja en barra");
        System.err.println("La barra tiene " + getCountBandejas() + " bandejas");
        //NOTIFICAMOS A TODOS
        notifyAll();
        //ECO BARRA LLENA 
        if (getCountBandejas() == CAPACIDAD_BANDEJAS) {
            System.out.println("La barra se ha llenado de tapas".toUpperCase());
            notifyAll();
        }
    }

    public synchronized void addbebida(Bebidas bebida) throws InterruptedException {
        //MIENTRAS SE LLEGUE A LA CAPACIDAD, EL CAMARERO ESPERA
        while (getCountBebidas() == CAPACIDAD_BEBIDAS) {
            wait();
        }
        //AÑADIMOS BEBIDA A LA BARRA
        lstBebidas.add(bebida);
        //ECOS
        System.out.println(Thread.currentThread().getName() + " pone " + bebida.getNombre() + " en barra");
        System.err.println("La barra tiene " + getCountBebidas() + " bebidas");
        //NOTIFICAMOS A TODOS
        notifyAll();
        //ECO BARRA LLENA DE BEBIDA
        if (getCountBebidas() == CAPACIDAD_BEBIDAS) {
            System.out.println("La barra se ha llenado de bebidas".toUpperCase());
            notifyAll();
        }
    }

    /**
     * Método que cuenta el nº de bandejas que hay en barra
     *
     * @return
     */
    public int getCountBandejas() {
        return lstBandejas.size();
    }

    /**
     * Método que cuenta el nº de bebidas que hay en barra
     *
     * @return
     */
    public int getCountBebidas() {
        return lstBebidas.size();
    }

    /**
     * Método con el que el cliente cogerá una bebida de las que hay en barra
     *
     * @return
     * @throws InterruptedException
     */
    public synchronized Bebidas removeBebidas() throws InterruptedException {
        //MIENTRAS NO SE VACÍE LA BARRA, LOS CLIENTES COGEN BEBIDAS
        while (getCountBebidas() == 0) {
            wait();
        }
        //CLIENTE COGE UNA BEBIDA ALEATORIAMENTE
        int ale = new Random().nextInt(getCountBebidas());
        Bebidas bebida = lstBebidas.get(ale);
        lstBebidas.remove(bebida);
        //ECOS
        System.out.println(Thread.currentThread().getName() + " compra " + bebida.getNombre() + "("
                + String.format("%.2f", bebida.getPrecio()) + "€)");
        //NOTIFICAMOS A TODOS
        notifyAll();
        //RETORNAMOS BEBIDA
        return bebida;
    }

    public synchronized Tapas removeTapas() throws InterruptedException {
        //MIENTRAS NO QUEDEN TAPAS EN BARRA LOS CLIENTES ESPERAN
        while (getCountBandejas() == 0) {
            wait();
        }
        try {
            //VAMOS DESGLOSANDO LAS TAPAS QUE HAY EN CADA BANDEJA 
            for (List<Tapas> bandeja : lstBandejas) {
                for (Tapas tapa : bandeja) {
                    //ELIMINAMOS LA TAPA DE LA BANDEJA
                    bandeja.remove(tapa);
                    System.out.println(Thread.currentThread().getName() + " compra "
                            + tapa.getNombre() + "(" + String.format("%.2f", tapa.getPrecio()) + "€");
                    //INTERRUMPIMOS AL HILO
                    Thread.currentThread().interrupt();
                    return tapa; 
                }
               
                System.err.println("Barra tiene " + getCountBandejas() + " bandejas");
            }
        } catch (ConcurrentModificationException cme) {

        }

        // lstBandejas.removeAll(lstBandejas);
        //NOTIFICAMOS A TODOS
        notifyAll();
        return null;
    }

    public synchronized void pagarCaja(Bebidas bebida, Tapas tapa) {

    }
}

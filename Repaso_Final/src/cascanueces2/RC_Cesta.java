/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cascanueces2;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 *
 * @author juanv
 */
public class RC_Cesta {

    //CONSTANTES
    private static final int CAPACIDAD_CESTA = 50;
    //CONTENEDOR
    private List<Nuez> lstNueces;

    //CONSTRUCTOR
    public RC_Cesta() {
        this.lstNueces = new ArrayList<>();
    }

    /**
     * Añadir nuez a la cesta
     */
    public synchronized void addNuez(Nuez nuez) throws InterruptedException {
        //MIENTRAS LA CESTA ESTÉ LLENA LOS NOGALES ESPERAN
        if (getCount() == CAPACIDAD_CESTA) {
            //ECO DE CESTA LLENA
            System.err.println("Cesta llena");
            //BUCLE DE ESPERA PARA HILOS PRODUCTORES MIENTRAS EL RC ESTÁ LLENO
            while (getCount() == CAPACIDAD_CESTA) {
                wait();
            }
        }

        //AÑADIMOS NUEZ A CESTA
        lstNueces.add(nuez);

        //ECOS
        System.out.println(Thread.currentThread().getName() + " mete " + nuez.getNombreNuez()
                + "(" + nuez.getN() + ")");
        System.err.println("La cesta tiene " + getCount() + " nueces");

        //NOTIFICAMOS A TODOS
        notifyAll();
    }

    public synchronized Nuez removeNuez() throws InterruptedException {
        //MIENTRAS NO HAYA NUECES EN LA CESTA, LOS CONSUMIDORES ESPERAN
        while (getCount() == 0) {
            wait();
        }
        //CASCANUECES COGE ALEATORIAMENTE NUEZ DE LA CESTA
        int ale = new Random().nextInt(getCount());
        Nuez nuez = lstNueces.get(ale);
        lstNueces.remove(nuez);
        //ECOS
        System.out.println(Thread.currentThread().getName() + " coge " + nuez.getNombreNuez()
                + "(" + nuez.getN() + ")");
        System.err.println("La cesta tiene " + getCount() + " nueces");

        //NOTIFICAMOS A TODOS
        notifyAll();

        //ECO CESTA VACÍA
        if (getCount() == 0) {
            System.err.println("La cesta se ha vaciado");
        }
        return nuez;
    }

    /**
     * Retorna el nº de nueces que hay en la cesta
     *
     * @return
     */
    public int getCount() {
        return lstNueces.size();
    }
    
    
}

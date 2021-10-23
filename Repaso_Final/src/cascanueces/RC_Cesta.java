/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cascanueces;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 *
 * @author juanv
 */
public class RC_Cesta {

    //CONSTANTES
    private static final int TAMANO_CESTA = 50;
    //CONTENEDOR
    private List<Nueces> lstNueces;
    private boolean nogalesMuertos;
    //CONSTRUCTOR
    public RC_Cesta() {
        this.lstNueces = new ArrayList<>();
        this.nogalesMuertos=false;
    }

    //MÉTODOS
    public synchronized void addNueces(Nueces nuez) throws InterruptedException {
        while (getCount() == TAMANO_CESTA) {
            wait();
        }
        //ANADIMOS NUECES A LA CESTA
        lstNueces.add(nuez);
        //ECOS
        System.out.println(Thread.currentThread().getName() + " ha anadido nuez "
                + nuez.getN() + " de " + nuez.getNombreNogal());
        System.err.println("La cesta tiene " + getCount() + " nueces");
        //NOTIFICAMOS A TODOS
        notifyAll();

        if (getCount() == TAMANO_CESTA) {
            System.out.println("La cesta se ha llenado");
            notifyAll();
        }
    }

    public int getCount() {
        return lstNueces.size();
    }

    public synchronized void removeNueces() throws InterruptedException {
        //MIENTRAS LA CESTA ESTÁ VACÍA LOS CASCANUECES ESPERAN
        while (getCount() == 0) {
            wait();
        }
        //ELIMINAMOS DE MANERA ALEATORIA LAS NUECES DE LA CESTA
        int ale = new Random().nextInt(lstNueces.size());
        Nueces nuez = lstNueces.get(ale);
        lstNueces.remove(nuez);
        //ECOS
        System.out.println(Thread.currentThread().getName() + " se ha comido "
                + nuez.getN() + " de " + nuez.getNombreNogal());
        System.err.println("La cesta tiene " + getCount() + " nueces");
        //NOTIFICAMOS A TODOS 
        notifyAll();
        //ECO DE CESTA VACÍA
        if (lstNueces.isEmpty()) {
            System.out.println("La cesta está vacía");
            notifyAll();
        }

    }

    public boolean isNogalesMuertos() {
        return nogalesMuertos;
    }

    public void setNogalesMuertos(boolean nogalesMuertos) {
        this.nogalesMuertos = nogalesMuertos;
    }
    

}

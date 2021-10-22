/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tuercas_y_tornillos;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author juanv
 */
public class RC_Caja {

    //CONSTANTES
    public final int TAMANO_CAJA = 25;
    //CONTENEDOR
    List<Blisters> lstBlisters;
    private double pasta;

    //CONSTRUCTOR
    public RC_Caja() {
        this.lstBlisters = new ArrayList<>();
        this.pasta=0;
    }

    //MÉTODOS
    public synchronized void addBlisters(Blisters blister) throws InterruptedException {
        //ASI LOS PRODUCTORES MUERAN NADA MÁS LLENAR EL RC, CON UN WHILE SE QUEDAN EN BUCLE
        if (!blisterLleno()) {
            //ANADIR BLISTER A CAJA
            lstBlisters.add(blister);
            //AÑADIMOS EL PRECIO AL TOTAL
            pasta+=blister.getPrecio();
            //ECOS
            System.out.println(Thread.currentThread().getName() + " ha anadido un blister de " + blister.getEtiqueta() + " a la caja");
            System.err.println("La caja tiene " + getCount() + " blisters");
            //NOTIFICAMOS
            notifyAll();
        }

    }

    public synchronized int getCount() {
        return lstBlisters.size();
    }

    public synchronized boolean blisterLleno() {
        return lstBlisters.size() == TAMANO_CAJA;
    }

    public double getPasta() {
        return pasta;
    }

    
}

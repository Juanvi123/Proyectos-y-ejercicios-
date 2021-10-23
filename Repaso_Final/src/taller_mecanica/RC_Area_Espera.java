/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package taller_mecanica;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author juanv
 */
public class RC_Area_Espera {

    //CONSTANTES
    private static final int CAPACIDAD = 50;
    //CONTENEDOR
    private List<Coches> lstCoches;

    //CONSTRUCTOR
    public RC_Area_Espera() {
        this.lstCoches = new ArrayList<>();
    }

    public synchronized void addCoche(Coches coche) throws InterruptedException {
        //SI EL ÁREA DE ESPERA SE LLENA, ESPERAR
        while (getCount() == CAPACIDAD) {
            wait();
        }
        //AÑADIMOS COCHE AL ÁREA DE ESPERA
        lstCoches.add(coche);
        //ECOS
        System.out.println(Thread.currentThread().getName()+" añade "+coche.getNombre()+""
                + " al área de espera");
        System.err.println("El área de espera tiene "+getCount()+" coches");
    }

    public int getCount() {
        return lstCoches.size();
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package heladeria;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 *
 * @author juanv
 */
public class RC_Nevera {

    //CONSTANTES
    private static final int CAPACIDAD_NEVERA = 25;
    //CONTENEDOR
    private List<Helados> lstHelado;

    //CONSTRUCTOR
    public RC_Nevera() {
        this.lstHelado = new ArrayList<>();
    }

    //MÉTODOS
    public synchronized void addHelado(Helados helado) throws InterruptedException {
        //MIENTRAS LA NEVERA ESTÉ LLENA LOS HELADEROS ESPERAN
        while (getCount() == CAPACIDAD_NEVERA) {
            wait();
        }
        //AÑADIMOS HELADO A NEVERA
        lstHelado.add(helado);
        //ECOS
        System.out.println(Thread.currentThread().getName() + " mete helado de "
                + helado.getSabor() + "(" + String.format("%.2f", helado.getPrecio()) + "€ )");
        System.err.println("La nevera tiene " + getCount() + " helados");
        //NOTIFICAMOS A TODOS
        notifyAll();
        //ECO NEVERA LLENA
        if (getCount() == CAPACIDAD_NEVERA) {
            System.err.println("La nevera se ha llenado");
            notifyAll();
        }
    }

    public synchronized Helados removeHelado() throws InterruptedException {
        //MIENTRAS LA NEVERA ESTÁ VACÍA
        while (getCount() == 0) {
            wait();
        }
        //SACAMOS ALEATORIAMENTE HELADO DE NEVERA
        int ale = new Random().nextInt(getCount());
        Helados helado = lstHelado.get(ale);
        lstHelado.remove(helado);
        //ECOS
        System.out.println(Thread.currentThread().getName() + " compra helado de "
                + helado.getSabor() + "(" + String.format("%.2f", helado.getPrecio()) + "€ )");
        System.err.println("La nevera tiene " + getCount() + " helados");
        //NOTIFICAMOS A TODOS
        notifyAll();
        //ECO NEVERA VACÍA
        if (getCount() == 0) {
            System.err.println("La nevera se ha vaciado");
            notifyAll();
        }
        return helado;
    }

    public int getCount() {
        return lstHelado.size();
    }
}

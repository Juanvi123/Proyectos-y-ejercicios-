/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gallinas_y_buitres;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 *
 * @author juanv
 */
public class RC_Huevera {

    //CONSTANTES
    private static final int TAMANO_HUEVERA = 12;
    //CONTENEDOR
    List<Huevo> lstHuevo;

    //CONSTRUCTOR
    public RC_Huevera() {
        this.lstHuevo = new ArrayList<>();
    }

    /**
     * Método para añadir el huevo de gallina o pularda a la huevera
     */
    public synchronized void addHuevo(Huevo huevo) throws InterruptedException {
        //MIENTRAS LA HUEVERA ESTÁ LLENA, LAS GALLINAS Y PULARDAS ESPERAN
        while (getCount() == TAMANO_HUEVERA) {
            wait();
        }
        //AÑADIMOS HUEVO A LA HUEVERA
        lstHuevo.add(huevo);
        //ECOS
        System.out.println(Thread.currentThread().getName() + " mete "
                + huevo.getNombreAnimal() + " con peso de " + huevo.getPeso() + "g");
        System.err.println("La huevera tiene " + getCount() + " huevos");
        //NOTIFICAMOS A TODOS
        notifyAll();
        //ECO HUEVERA LLENA
        if (getCount() == TAMANO_HUEVERA) {
            System.out.println("La huevera se ha llenado");
            notifyAll();
        }
    }

    /**
     * Retorna el nº de huevos que hay en la huevera en cada momento
     *
     * @return
     */
    public int getCount() {
        return lstHuevo.size();
    }
    
    /**
     * Método con el que los buitres y las hurracas cogerán los huevos
     */
    public synchronized Huevo cogerHuevo() throws InterruptedException{
        //MIENTRAS NO HAYA HUEVOS EN LA HUEVERA LAS HURRACAS Y LOS 
        //BUITRES ESPERAN
        while(getCount()==0)
            wait();
        //QUITAMOS HUEVO DE HUEVERA DE MANERA ALEATORIA
        int ale=new Random().nextInt(getCount());
        Huevo huevo=lstHuevo.get(ale);
        lstHuevo.remove(huevo);
        //ECO
            System.err.println("La huevera tiene " +getCount() + " huevos");
        //NOTIFICAMOS A TODOS
        notifyAll();
        //ECO HUEVERA VACÍA
        if(getCount()==0)
            System.out.println("La huevera se ha vaciado");
        return huevo;
        //ECOS
        
    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package taller_mecanica;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 *
 * @author juanv
 */
public class RC_Banco_Mecanicos {

    //CONSTANTES
    private static final int CAPACIDAD = 7;
    //CONTENEDOR
    List<Mecanicos> lstMecanicos;
    //SEMAFORO
    private boolean semaforo;
    //RC AREA DE ESPERA
    RC_Area_Espera area_Espera;
    
    RC_Caja_Herramientas caja_herramientas;

    //CONSTRUCTOR
    public RC_Banco_Mecanicos() {
        this.lstMecanicos = new ArrayList<>();
        this.semaforo = false;
        this.area_Espera = new RC_Area_Espera();
        this.caja_herramientas = new RC_Caja_Herramientas();
        
    }

    public synchronized void addMecanico(Mecanicos mecanico) throws InterruptedException {
        //SI EL Nº DE MECÁNICOS SUPERA A LA CAPACIDAD, ESPERA
        while (semaforo) {
            wait();
        }
        //AÑADIMOS MECÁNICO AL BANCO
        lstMecanicos.add(mecanico);
        System.err.println("El banco tiene " + getCount() + " mecanicos");
        
        //Dejamos la herramienta en la caja cuando esta no este llena
        if(caja_herramientas.getCount() != 5){
            caja_herramientas.dejarHerramienta();
        }
        
        
        //NOTIFICAMOS A TODOS
        notifyAll();
        if (getCount() == CAPACIDAD) {
            semaforo = true;
        }
    }

    /**
     * Método que te devuelve el nº de mecánicos en la list
     *
     * @return
     */
    public int getCount() {
        return lstMecanicos.size();
    }

    public synchronized void asignarCoche(Coches coche) throws InterruptedException {
        //MIENTRAS NO QUEDE ALGÚN MECÁNICO EN EL BANCO, ESPERAN
        while (semaforo == false) {
            wait();
        }
        //QUITAMOS UN MECÁNICO DEL BANCO ALEATORIAMENTE
        int ale = new Random().nextInt(getCount());
        Mecanicos mecanico = lstMecanicos.get(ale);
        lstMecanicos.remove(mecanico);
        
        //Mira el numero de herramientas que tenemos en la caja
        int numeroHerramientas = caja_herramientas.getCount();
        
        //ASIGNAR COCHE A MECANICO
        try {
            if (numeroHerramientas > 0 && mecanico.getCoche().equals(null)) {

            }//SI EL MECÁNICO YA TIENE ASIGNADO COCHE
            else {
                //METEMOS COCHE EN EL ÁREA DE ESPERA
                area_Espera.addCoche(coche);
            }
        } catch (NullPointerException ne) {
            mecanico.setCoche(coche);
            caja_herramientas.cogerHerramienta();
        }

        //ECO
        System.out.println(Thread.currentThread().getName() + " le asigna "
                + coche.getNombre() + " a " + mecanico.getName());
        System.err.println("El banco de mecánicos tiene " + getCount() + " mecánicos");
        
        if(numeroHerramientas > 0 && numeroHerramientas <= 5){
            System.out.println("El "+mecanico.getName()+" coge la herramienta numero "+numeroHerramientas
                    +" de la caja");
            System.err.println("La caja de Herramientas tiene "+caja_herramientas.getCount()+" herramientas");
        }
        

        if (getCount() == 0) {
            semaforo = false;
            //NOTIFICAMOS A TODOS
            notifyAll();
        }
    }
}

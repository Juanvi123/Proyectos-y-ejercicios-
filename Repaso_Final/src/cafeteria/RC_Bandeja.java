/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cafeteria;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 *
 * @author juanv
 */
public class RC_Bandeja {

    //CONSTANTES
    private static final int CAPACIDAD_BANDEJA = 50;
    //CONTENEDOR
    List<Bocadillos> lstBocadillos;
    //VARIABLES
    private double recaudacion;
    private boolean tiendaAbierta;

    //CONSTRUCTOR
    public RC_Bandeja() {
        this.lstBocadillos = new ArrayList<>();
        this.recaudacion=0.0;
        this.tiendaAbierta=false;
    }
    //MÉTODOS

    public synchronized void addBocata(Bocadillos bocadillo) throws InterruptedException {
        //MIENTRAS LA BANDEJA ESTÉ LLENA, LAS CAMARERAS ESPERAN
        while (getCount() == CAPACIDAD_BANDEJA) {
            wait();
        }
        //AÑADIMOS BOCATA A LA BANDEJA
        lstBocadillos.add(bocadillo);
        //ECOS
        System.out.println(Thread.currentThread().getName() + " mete bocadillo de "
                + bocadillo.getNombreBocata() + " en bandeja");
        System.err.println("La bandeja tiene " + getCount() + " bocatas");

        //NOTIFICAMOS A TODOS
        notifyAll();

        //ECO BANDEJA LLENA
        if (getCount() == CAPACIDAD_BANDEJA) {
            System.err.println("Bandeja llena");
            //ABRIMOS LA TIENDA
            marcarTiendaAbierta();
            notifyAll();
        }
    }

    public int getCount() {
        return lstBocadillos.size();
    }

    public synchronized Bocadillos removeBocata() throws InterruptedException {
        //MIENTRAS NO HAYA BOCATAS EN LA BANDEJA, LOS CLIENTES ESPERAN
        while (getCount() == 0 || !tiendaAbierta) {
            wait();
        }
        //CLIENTE COGE ALEATORIAMENTE BOCATA
        int ale = new Random().nextInt(getCount());
        Bocadillos bocata = lstBocadillos.get(ale);
        lstBocadillos.remove(bocata);

        //ECOS
        System.out.println(Thread.currentThread().getName() + " coge bocata de " + bocata.getNombreBocata()
                + "(" + String.format("%.2f", bocata.getPrecio()) + "€ )");
        System.err.println("La bandeja tiene " + getCount() + " bocatas");
        //NOTIFICAMOS A TODOS
        notifyAll();

        //ECO BANDEJA VACÍA
        if (getCount() == 0) {
            System.err.println("La bandeja se ha vaciado");
            //NOTIFICAMOS
            notifyAll();
        }
        return bocata;
    }

    public synchronized void pagarBocata(Bocadillos bocata) {
      recaudacion+=bocata.getPrecio();
    }
    
    public void recaudacion(){
        System.out.println("Se ha recaudado en total: "+String.format("%.2f", recaudacion)+"€");
    }
    
    public synchronized boolean marcarTiendaAbierta(){
        return tiendaAbierta=true;
    }
}

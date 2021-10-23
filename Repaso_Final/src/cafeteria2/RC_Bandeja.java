/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cafeteria2;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 *
 * @author juanv
 */
public class RC_Bandeja {

    //CONSTANTES
    private static final int CAPACIDAD = 50;
    //CONTENEDOR
    private List<Bocatas> lstBocatas;
    //BOOLEANO CONTROLAR EL LLENADO DE LA BANDEJA
    private boolean bandejaLlena; //true LLENA false VACIA
    private boolean abrirTienda;
    private double ganancias;

    //CONSTRUCTOR
    public RC_Bandeja() {
        this.lstBocatas = new ArrayList<>();
        //INICIALMENTE LA BANDEJA ESTÁ VACÍA
        this.bandejaLlena = false;
        //INICIALMENTE LA TIENDA ESTÁ CERRADA AL PÚBLICO
        this.abrirTienda = false;
        this.ganancias=0.0;
    }

    /**
     * Método donde las camareras meterán los bocatas
     */
    public synchronized void addBocata(Bocatas bocata) throws InterruptedException {
        //MIENTRAS LA BANDEJA ESTÉ LLENA O SE MARQUE COMO LLENA, LAS CAMARERAS ESPERAN
        while (bandejaLlena) {
            wait();
        }
        //AÑADIMOS BOCATA A LA BANDEJA
        lstBocatas.add(bocata);
        //ECOS
        System.out.println(Thread.currentThread().getName() + " mete " + bocata.getNombreBocata()
                + "(" + String.format("%.2f", bocata.getPrecioBocata()) + "€)");
        System.err.println("La bandeja tiene " + getCount() + " bocatas");
        //NOTIFICAMOS A TODOS
        notifyAll();
        //MARCAR LLENA
        if (getCount() == CAPACIDAD) {
            //MARCAMOS LA BANDEJA LLENA
            bandejaLlena = true;
            //ECO
            System.err.println("La bandeja se ha llenado");
            //NOTIFICAMOS A TODOS
            notifyAll();
        }
    }

    /**
     * Con este método permitiremos que si la bandeja no se ha llenado pero los
     * camareros han hecho todos sus bocatas, que se abran las puertas y los
     * clientes entren
     *
     * @return
     */
    public synchronized boolean marcarBandejaLlena() {
        return bandejaLlena = true;
    }

    /**
     * Método que retorna el nº de bocatas que hay en la bandeja
     *
     * @return
     */
    public int getCount() {
        return lstBocatas.size();
    }

    /**
     * Método que utilizará el cliente para coger bocata
     *
     * @return
     */
    public synchronized Bocatas removerBocata() throws InterruptedException {
        //MIENTRAS NO HAYA BOCATAS o LA TIENDA ESTÉ CERRADA ESPERA
        while (!bandejaLlena || !abrirTienda) {
            wait();
        }
        //CLIENTE COGE ALEATORIAMENTE UN BOCATA DE LA BANDEJA
        int ale = new Random().nextInt(getCount());
        Bocatas bocata = lstBocatas.get(ale);
        //ELIMINAMOS BOCATA DE BANDEJA
        lstBocatas.remove(bocata);
       
        //ECOS
        System.out.println(Thread.currentThread().getName() + " coge " + bocata.getNombreBocata()
                + "(" + String.format("%.2f", bocata.getPrecioBocata()) + "€)");
        System.err.println("La bandeja tiene " + getCount() + " bocatas");
        //NOTIFICAMOS A TODOS
        notifyAll();
        if (getCount() == 0) {
            //CAMBIAMOS EL VALOR DE BANDEJA
            bandejaLlena = false;
            //ECO
            System.err.println("La bandeja se ha vaciado");
            //NOTIFICAMOS A TODOS
            notifyAll();
        }
        //RETORNAMOS EL BOCATA
        return bocata;
    }
    
    public synchronized void pagarBocata(Bocatas bocata) {
        //ANOTAMOS EL PRECIO DEL BOCATA EN GANANCIAS
        ganancias+=bocata.getPrecioBocata();
    }
    
    //GETTER
    public double getGanancias() {
        return ganancias;
    }

    public boolean isAbrirTienda() {
        return abrirTienda;
    }

    public void setAbrirTienda(boolean abrirTienda) {
        this.abrirTienda = abrirTienda;
    }
    
    
    
}

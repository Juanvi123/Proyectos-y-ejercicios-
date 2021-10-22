/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package supermercado_v3_varios_reponedores_cero_articulos;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 *
 * @author juanv
 */
public class RC_Estanteria {
    //CONSTANTES
    private static final int N_MAX_ARTICULOS=50;
    //CONTENEDOR
    private List<Articulos> lstArticulos;
    private double recaudacion;

    public RC_Estanteria() {
        this.lstArticulos = new ArrayList<>();
    }

    //MÉTODOS
    public synchronized void addArticulo(Articulos articulo) throws InterruptedException {
        while(getCount()==N_MAX_ARTICULOS)
            wait();
        //REPONEDOR COLOCA ARTÍCULO
        lstArticulos.add(articulo);
        //ECOS
        System.out.println(Thread.currentThread().getName() + " mete "
                + articulo.getNombre() + "(" + articulo.getPrecio() + ")");
        System.err.println("La estantería tiene " + getCount() + " artículos");
        //NOTIFICAMOS A TODOS
        notifyAll();
        //ECO DE LLENADO
        if(getCount()==N_MAX_ARTICULOS){
            System.err.println("Estantería llena");
            notifyAll();
        }

    }

    public int getCount() {
        return lstArticulos.size();
    }

    public synchronized Articulos removeArticulos() throws InterruptedException {
        while (getCount() == 0) {
            wait();
        }
        //LOS CLIENTES COGEN UN ARTICULO DE MANERA DE ALEATORIA
        int ale = new Random().nextInt(getCount());
        Articulos articulo = lstArticulos.get(ale);
        lstArticulos.remove(articulo);
        System.out.println(Thread.currentThread().getName() + " se ha llevado "
                + articulo.getNombre());
        System.err.println("La estantería tiene " + getCount() + " artículos");
        //NOTIFICAMOS A TODOS
        notifyAll();
        if (getCount() == 0) {
            System.err.println("La estantería se ha vaciado");
            notifyAll();
        }
        return articulo;
    }

    public synchronized void pagarCajera(Articulos articulo) {
        recaudacion += articulo.getPrecio();
        System.out.println(Thread.currentThread().getName() + " paga a cajera "
                + String.format("%.2f", articulo.getPrecio()) + "€ por " + articulo.getNombre());

    }

    //GETTER
    public double getRecaudacion() {
        return recaudacion;
    }

}

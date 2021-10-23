/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package supermercado_1_cliente;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 *
 * @author juanv
 */
public class RC_Estanteria {

    //CONTENEDOR
    private List<Articulos> lstArticulos;
    private double recaudacion;

    public RC_Estanteria() {
        this.lstArticulos = new ArrayList<>();
    }

    //MÉTODOS
    public void addArticulo(Articulos articulo) {
        //REPONEDOR COLOCA ARTÍCULO
        lstArticulos.add(articulo);
        //ECOS
        System.out.println(Thread.currentThread().getName() + " mete "
                + articulo.getNombre() + "(" + articulo.getPrecio() + ")");
        System.err.println("La estantería tiene " + getCount() + " artículos");

    }

    public int getCount() {
        return lstArticulos.size();
    }

    public synchronized Articulos removeArticulos() {
        //LOS CLIENTES COGEN UN ARTICULO DE MANERA DE ALEATORIA
        int ale = new Random().nextInt(getCount());
        Articulos articulo = lstArticulos.get(ale);
        lstArticulos.remove(articulo);
        System.out.println(Thread.currentThread().getName() + " se ha llevado "
                + articulo.getNombre());
        System.err.println("La estantería tiene " + getCount() + " artículos");
        //NOTIFICAMOS A TODOS
        notifyAll();
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

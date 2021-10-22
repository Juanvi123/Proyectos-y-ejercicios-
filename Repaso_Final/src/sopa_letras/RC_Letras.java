/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sopa_letras;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.DoubleStream;

/**
 *
 * @author juanv
 */
public class RC_Letras {

    //CONSTANTES
    private static final int CAPACIDAD = 2;
    //CONTENEDOR
    List<String> lstCombinacion;
    //CADENA
    private String cadena;
    //SEMAFORO
    private boolean cadenaLista;
    private boolean combinacionEncontrada;
    int n;

    //CONSTRUCTOR
    public RC_Letras() {
        this.lstCombinacion = new ArrayList<>();
        this.cadena = "";
        this.cadenaLista = false;
        this.n = 0;
        this.combinacionEncontrada = false;
    }

    //MÉTODOS
    public synchronized void addLetra(char letra) throws InterruptedException {
        //MIENTRAS HAYA UNA COMBINACIÓN, LOS GENERADORES ESPERAN
        while (getCount() == CAPACIDAD) {
            wait();
        }
        //AÑADIMOS LETRA AL CONTENEDOR
        lstCombinacion.add(String.valueOf(letra));
        System.out.println(Thread.currentThread().getName() + " mete letra " + letra);
        //CUANDO LA CADENA SE LLENÓ
        if (getCount() == CAPACIDAD) {
            //AÑADIMOS LETRA A LA CADENA
            cadena = lstCombinacion.get(0) + lstCombinacion.get(1);
            //NOTIFICAMOS
            notifyAll();

        }

    }

    public synchronized void comprobarCadena() throws InterruptedException {
        //MIENTRAS NO SE HA FORMADO LA CADENA, ESPERA
        while (getCount() != CAPACIDAD) {
            wait();
        }
       /* StringBuilder builder = new StringBuilder(cadena);
        String cadenaInvert = builder.reverse().toString();*/
        if (cadena.trim().toUpperCase().equals("AZ")) {
            combinacionEncontrada = true;
        } else {
            System.out.println("Combinación: " + cadena);
            System.err.println(Thread.currentThread().getName() + " no encontró la combiación");
            cadena = "";
            lstCombinacion.removeAll(lstCombinacion);
        }
        notifyAll();
    }

    public int getCount() {
        return lstCombinacion.size();
    }

    //GETTERS
    public String getCadena() {
        return cadena;
    }

    public synchronized boolean isCombinacionEncontrada() {
        return combinacionEncontrada;
    }

}

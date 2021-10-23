/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grupos_hilos;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author juanv
 */
public class RC_Suma_Numeros {

    //CONSTANTES
    private static final int CAPACIDAD = 2;

    //CONTENEDOR
    private List<Integer> lstNumeros;

    //VARIABLES
    private int suma;
    private int acumulado;

    //CONSTRUCTOR
    public RC_Suma_Numeros() {
        this.lstNumeros = new ArrayList<>();
        this.suma = 0;
        this.acumulado = 0;
    }

    /**
     * Método donde comtamos el nº de elementos que tiene la List
     *
     * @return
     */
    public int getCount() {
        return lstNumeros.size();
    }

    public synchronized void addNumero(int n) throws InterruptedException {
        //MIENTRAS LA LIST ESTÉ LLENA LOS HILOS ESPERAN
        while (getCount() == CAPACIDAD) {
            wait();
        }
        //METEMOS Nº EN LA LIST
        lstNumeros.add(n);

        //ECO
        System.out.println(Thread.currentThread().getName() + " mete nº " + n);

        //NOTIFICAMOS A TODOS
        notifyAll();

        //ECO DE LLENADO
        if (getCount() == CAPACIDAD) {
            System.err.println("Lista llena");
        }
    }

    public synchronized void sumarNumeros() throws InterruptedException {
        //MIENTRAS NO HAYA 2 Nºs PARA SUMAR ESPERA
        while (getCount() < CAPACIDAD) {
            wait();
        }

        //SUMAMOS AMBOS Nºs
        for (Integer numero : lstNumeros) {
            suma += numero;
        }

        //AÑADIMOS LA SUMA AL ACUMULADO
        acumulado += suma;

        //ECO
        System.out.println(Thread.currentThread().getName() + " suma "
                + lstNumeros.get(0) + " + " + lstNumeros.get(1) + "= " + suma);

        //VACIAMOS LISTA Y VARIABLE
        lstNumeros.removeAll(lstNumeros);
        suma = 0;

        //NOTIFICAMOS A TODOS
        notifyAll();
    }

    //GETTER
    public int getAcumulado() {
        return acumulado;
    }
}

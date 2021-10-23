/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hilos_primos;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author juanv
 */
public class RC_Comprobar_Numero {

    //CONSTANTES
    private static final int CAPACIDAD = 1;
    //CONTENEDOR
    private List<Numeros> lstNumeros;

    //INSTANCIAMOS NUMERO
    Numeros numero;

    //CONSTRUCTOR
    public RC_Comprobar_Numero(Numeros numero) {
        this.lstNumeros = new ArrayList<>();
        this.numero = numero;
    }

    public synchronized void incrementarNumero(int n) throws InterruptedException {
        while (getCount() == CAPACIDAD) {
            wait();
        }
        //INCREMENTAMOS Nº
        System.out.println(Thread.currentThread().getName() + " mete nº " + n);
        numero.setN(numero.getN()+n);
        //ECO
        System.err.println("nº ahora vale: "+numero.getN());
        //AÑADIMOS NUMERO A LA LISTA
        lstNumeros.add(numero);
        //NOTIFICAMOS A TODOS
        notifyAll();

    }

    public int getCount() {
        return lstNumeros.size();
    }

    public Numeros removeNumero() {
        Numeros numero = lstNumeros.get(0);
        lstNumeros.remove(numero);
        return numero;
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hilos_primos;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 *
 * @author juanv
 */
public class Main_Hilos_Primos {

    //CONSTANTES
    private static final int N_MIN_HILOS_PRIMOS = 4;
    private static final int N_MAX_HILOS_PRIMOS = 8;
    private static final int N_MIN_HILOS_INCREMENTO = 2;
    private static final int N_Max_HILOS_INCREMENTO = 12;

    public static void main(String[] args) {
        //INSTANCIAMOS EL Nº
        Numeros numero = new Numeros();
        System.out.println("nº inicial: " + numero.getN());
        //DEFINIMOS EL Nº DE HILOS INCREMENTO E HILOS PRIMOS
        int nHilosPrimos = new Random().nextInt((N_MAX_HILOS_PRIMOS - N_MIN_HILOS_PRIMOS) + 1) + N_MIN_HILOS_PRIMOS;
        int nHilosIncremento = new Random().nextInt((N_Max_HILOS_INCREMENTO - N_MIN_HILOS_INCREMENTO) + 1) + N_MIN_HILOS_INCREMENTO;
        System.out.println("nº hilos primos: " + nHilosPrimos);
        System.out.println("nº hilos incremento: " + nHilosIncremento+"\n");
        
        //INSTANCIAMOS RC
        RC_Comprobar_Numero comprobar_Numero = new RC_Comprobar_Numero(numero);
        
        //INSTANCIAMOS HILOS INCREMENTO
        List<Hilos_Incremento> lstHilosIncremento = new ArrayList<>();
        for(int i=0;i<nHilosIncremento;i++){
            lstHilosIncremento.add(new Hilos_Incremento(comprobar_Numero));
            lstHilosIncremento.get(i).setName("Hilo_Incremento "+(i+1));
            lstHilosIncremento.get(i).setDaemon(true);
            lstHilosIncremento.get(i).start();
        }
        
        //INSTANCIAMOS HILOS PRIMOS
        List<Hilos_Primos>lstHilosPrimos=new ArrayList<>();
        for(int i=0;i<nHilosPrimos;i++){
            lstHilosPrimos.add(new Hilos_Primos(comprobar_Numero));
            lstHilosPrimos.get(i).setName("Hilos_Primo "+(i+1));
            lstHilosPrimos.get(i).start();
        }
    }
}

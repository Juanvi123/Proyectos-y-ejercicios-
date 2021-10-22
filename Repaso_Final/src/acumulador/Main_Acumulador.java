/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package acumulador;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author juanv
 */
public class Main_Acumulador {

    //CONSTANTES
    private static final int N_HILOS = 30;
    
    public static void main(String[] args) throws InterruptedException {
        //INSTANCIAMOS RC
        RC_Acumulador acumulador = new RC_Acumulador();

        //INSTANCIAMOS, INICIALIZAMOS Y ARRANCAMOS HILOS
        List<Hilo> lstHilos = new ArrayList<>();
        for (int i = 0; i < N_HILOS; i++) {
            lstHilos.add(new Hilo(acumulador));
            lstHilos.get(i).setName("Hilo " + (i + 1));
            lstHilos.get(i).start();
        }
        //ESPERAMOS A QUE LOS HILOS MUERAN
        for (int i = 0; i < N_HILOS; i++) {
            lstHilos.get(i).join();
        }
        for (int i = 0; i < N_HILOS; i++) {
            while (lstHilos.get(i).isAlive()) {
                Thread.sleep(10);
            }
        }
        Thread.sleep(1000);
        System.out.println("\nAcumulador: "+acumulador.getN());
        System.out.println(Thread.currentThread().getName()+" FIN");
    }
}

/*
En un sistema hay un semáforo .

Un hiloA se encarga de ponerlo rojo y verde alternativamente y de forma 
continuada haciendo una espera aleatoria ( 5 – 15 ).

Los hilosB corren  ( espera aleatoria  35-70 )  hasta que llegan al semáforo ; 
paran si está rojo . Si está verde incrementan un contador y repiten la espera 
aleatoria 35-70 . Al crear el hiloB se da un número y cuando el contador iguale
el número , el hilo finalizará .

Al iniciar el sistema , se creará un hiloA  y un número aleatorio de hilosB 
(50-100) ; a cada hiloB se dará un número aleatorio ( 9-200) que permitirá 
finalizar al hiloB.

El ultimo hiloB se encargará de finalizar el hiloA y terminar el sistema .

– hay más de una solución razonada –

 */
package semaforo_y_contador2;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 *
 * @author juanv
 */
public class Main_Semaforo_Y_Contador {

    //CONSTANTES
    private static final int N_MIN_HILOS_B = 50;
    private static final int N_MAX_HILOS_B = 100;

    public static void main(String[] args) throws InterruptedException {
        //DEFINIMOS EL Nº DE HILOS B
        int nB = new Random().nextInt((N_MAX_HILOS_B - N_MIN_HILOS_B) + 1) + N_MIN_HILOS_B;
        System.out.println("Se han creado " + nB + " Hilos_B");
        //INSTANCIAMOS RC
        Semaforo semaforo = new Semaforo();
        //INSTANCIAMOS, INICIALIZAMOS Y ARRANCAMOS HILOA
        Hilo_A hilo_A = new Hilo_A(semaforo);
        hilo_A.setName("Hilo_A");
        hilo_A.setDaemon(true);
        hilo_A.start();

        //INSTANCIAMOS, INICIALIZAMOS Y ARRANCAMOS LOS HILOS_B
        List<Hilos_B> lstHilos_B = new ArrayList<>();
        for (int i = 0; i < nB; i++) {
            lstHilos_B.add(new Hilos_B(semaforo));
            lstHilos_B.get(i).setName("Hilo_B " + (i + 1));
            lstHilos_B.get(i).start();
        }
        //ESPERAMOS A QUE LOS HILO_B MUERAN
        for (int i = 0; i < nB; i++) {
            lstHilos_B.get(i).join();
        }
        for (int i = 0; i < nB; i++) {
            while (lstHilos_B.get(i).isAlive()) {
                Thread.sleep(10);
            }
        }
        Thread.sleep(10);
        System.out.println(lstHilos_B.get(nB - 1).getName() + " interrumpe a " + hilo_A.getName());
        System.out.println(Thread.currentThread().getName() + " FIN");
    }

}

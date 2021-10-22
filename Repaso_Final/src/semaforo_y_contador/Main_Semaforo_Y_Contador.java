/*
En un sistema hay un semáforo .

Un hiloA se encarga de ponerlo rojo y verde alternativamente y de forma
continuada haciendo una espera aleatoria ( 5 – 15 ).

Los hilosB corren  ( espera aleatoria  35-70 )  hasta que llegan al semáforo 
; paran si está rojo . Si está verde incrementan un contador y repiten la 
espera aleatoria 35-70 . Al crear el hiloB se da un número y cuando el 
contador iguale el número , el hilo finalizará .

Al iniciar el sistema , se creará un hiloA  y un número aleatorio de hilosB 
(50-100) ; a cada hiloB se dará un número aleatorio ( 9-200) que permitirá 
finalizar al hiloB.

El ultimo hiloB se encargará de finalizar el hiloA y terminar el sistema .

– hay más de una solución razonada –

 */
package semaforo_y_contador;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 *
 * @author juanv
 */
public class Main_Semaforo_Y_Contador {

    //CONSTANTES
    private static final int N_MIN_HILOSB = 50;
    private static final int N_MAX_HILOSB = 100;

    public static void main(String[] args) throws InterruptedException {
        //DEFINIMOS EL Nº DE HILOS B
        int nHilosB = new Random().nextInt((N_MAX_HILOSB - N_MIN_HILOSB) + 1) + N_MIN_HILOSB;
        //ECO Nº HILOS B
        System.out.println("Se han creado " + nHilosB + " hilos B\n");
        //INSTANCIAMOS RC
        RC_Semaforo semaforo = new RC_Semaforo();
        //INSTANCIAMOS HILO A
        HiloA hiloA = new HiloA(semaforo);
        hiloA.setName("HiloA");
        hiloA.setDaemon(true);
        hiloA.start();

        //INSTANCIAMOS HILOS B
        List<HilosB> lstHilosB = new ArrayList<>();
        for (int i = 0; i < nHilosB; i++) {
            lstHilosB.add(new HilosB(semaforo));
            lstHilosB.get(i).setName("Hilo_B " + (i + 1));
            lstHilosB.get(i).start();
        }

        //ESPERAMOS AL ÚLTIMO HILO B
        for (int i = 0; i < nHilosB; i++) {
            lstHilosB.get(i).join();
        }
        for (int i = 0; i < nHilosB; i++) {
            while (lstHilosB.get(i).isAlive()) {
                Thread.sleep(10);
            }
        }
        System.out.println(lstHilosB.get(nHilosB - 1).getName() + " finaliza a "
                + hiloA.getName());
        System.out.println(Thread.currentThread().getName() + " FIN");
    }
}

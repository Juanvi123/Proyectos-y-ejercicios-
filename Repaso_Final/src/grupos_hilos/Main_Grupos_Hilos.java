/*
 Grupos de hilos A , B y C .
Grupo A , hilos nombrados : A1, A2 .
Grupo B , hilos nombrados : B1 , B2 , B3 , B4 .
Grupo C , hilos nombrados : C1 , C2 , C3 .
Los hilos del grupo A meterán un nº en un RC
Los hilos del grupo B meterán otro nº en un RC
Los hilos del grupo C suman dos números obtenidos aleatoriamente e imprimen 
el resultado .
El hilo main tras crear y arrancar los hilos, esperará 30 segundos ,
interrumpirá a los hilos y finalizará . Para
interrumpir a los hilos , utilizará una interrupción por grupo de hilos . 
Escribirá varios mensajes : un mensaje de inicio con su nombre , otro mensaje
inmediatamente antes de interrumpir y otro mensaje de finalización .
Cada hilo escribirá un mensaje de inicio con su nombre y otro de finalización . 
El mensaje de finalización
contendrá : nombre del hilo , su grupo y los indicativos adecuados para saber 
si estaba en espera activa o
pasiva cuando fue interrumpido .
 */
package grupos_hilos;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author juanv
 */
public class Main_Grupos_Hilos {

    //CONSTANTES
    private static final int TIEMPO_HASTA_INTERRUPCION=15000;

    public static void main(String[] args) throws InterruptedException {
        //INSTANCIAMOS RC
        RC_Suma_Numeros suma_Numeros = new RC_Suma_Numeros();
        //CREAMOS GRUPOS DE HILOS
        ThreadGroup tGA = new ThreadGroup("Grupo A");
        ThreadGroup tGB = new ThreadGroup("Grupo B");
        ThreadGroup tGC = new ThreadGroup("Grupo C");

        //INSTANCIAMOS PRODUCTORES
        Threads_A threads_A = new Threads_A(suma_Numeros);
        Threads_B threads_B = new Threads_B(suma_Numeros);

        Thread A1 = new Thread(tGA, threads_A, "A1");
        Thread A2 = new Thread(tGA, threads_A, "A2");

        Thread B1 = new Thread(tGB, threads_B, "B1");
        Thread B2 = new Thread(tGB, threads_B, "B2");
        Thread B3 = new Thread(tGB, threads_B, "B3");
        Thread B4 = new Thread(tGB, threads_B, "B4");

        //ARRANCAMOS HILOS PRODUCTORES
        A1.start();
        A2.start();

        B1.start();
        B2.start();
        B3.start();
        B4.start();

        //INSTANCIAMOS CONSUMIDORES
        Threads_C threads_C = new Threads_C(suma_Numeros);
        Thread C1 = new Thread(tGC, threads_C, "C1");
        Thread C2 = new Thread(tGC, threads_C, "C2");
        Thread C3 = new Thread(tGC, threads_C, "C3");
        
        //ARRANCAMOS HILOS CONSUMIDORES
        C1.start();
        C2.start();
        C3.start();
        
        //TIEMPO HASTA INTERRUPCIÓN
        Thread.sleep(TIEMPO_HASTA_INTERRUPCION);
        //ECO FIN MAIN
        System.out.println(Thread.currentThread().getName()+" FIN, "
                + "la suma de todo da "+suma_Numeros.getAcumulado());
        //MAIN INTERRUMPE A TODOS
        Thread.currentThread().getThreadGroup().interrupt();
    }

}

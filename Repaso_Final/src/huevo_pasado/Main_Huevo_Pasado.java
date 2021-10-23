/*
Un huevo contiene una letra y un contador .
El hilo main crea un huevo , inicializa letra=”a” y contador =0 . Crea un hilo , 
le pasa el huevo y espera a que
finalice ; escribiendo “FIN” y el nombre del hilo .
El hilo creado, antes de hacer la espera aleatoria, comprobará el contador es mayor
que 25 o bien la letra es la
letra z y entonces finalizará escribiendo “FIN” y el nombre del hilo.
El hilo creado recibe el huevo , hace una espera aleatoria (5-25 ) ; incrementa en uno
el contador ; y suma un
número aleatorio ( 5-15 ) a la letra para obtener una nueva letra , crea otro hilo ,
le pasa el huevo , espera a que
finalice y escribe un mensaje “FIN” y el nombre del hilo.
Escribir un planificador que lance la tarea anterior cada segundo .
 */
package huevo_pasado;

import java.util.Timer;
import java.util.TimerTask;

/**
 *
 * @author juanv
 */
public class Main_Huevo_Pasado {

    public static void main(String[] args) {

        //CREAMOS PLANIFICADOR
        Timer timer = new Timer();
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                //INSTANCIAMOS E INICIALIZAMOS HUEVO
                Huevo huevo = new Huevo('a', 0);
                //INSTANCIAMOS E INICIALIZAMOS HILO
                Hilo hilo = new Hilo(huevo);
                hilo.setName("Hilo " + (huevo.getContador() + 1));
                //ARRANCAMO HILO
                hilo.start(); 
            }
        };
        //INICIALIZAMO RESTO VARIABLES
        int retardo = 0;
        int intervalo = 3000;
        //LANZAMOS TAREA
        timer.schedule(task, retardo, intervalo);

    }
}

/*
Una bola contiene un acumulador de tiempo y un contador de hilos.
El hilo main crea la bola y inicializa ambos acumulador y contador. Crea un
hilo y le pasa la bola.
El hilo creado recibe la bola hace una espera aleatoria (1-25 segundos) ;
incrementa en uno el contador de hilos ;
suma en el acumulador de tiempo el tiempo de espera aleatoria , crea 
otro hilo y le pasa la bola. Y escribe un
mensaje con su nombre y “FIN”.
El hilo creado, antes de hacer la espera aleatoria, comprobará el 
acumulador de tiempo y el contador de hilos de
la bola recibida. Si la bola ha pasado por más de 15 hilos o si el tiempo 
acumulado en la bola es mayor de 100, no
pasará la bola a ningún otro hilo. Escribirá un mensaje “NO PASO LA BOLA
A NADIE” y acabará.
 */
package hilos_bolas;

/**
 *
 * @author juanv
 */
public class Main_Hilos_Bolas {

    public static void main(String[] args) {
       //INSTANCIA DE BOLA
       Bola bola=new Bola(0, 0);
       //INSTANCIA DE HILO
       Hilo hilo=new Hilo(bola);
       hilo.setName("Hilo "+(bola.getCont()+1));
       hilo.start();
    }

}

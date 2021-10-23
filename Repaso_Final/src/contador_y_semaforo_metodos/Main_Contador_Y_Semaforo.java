/*
Contador : CERO inicialmente
hilo1:
1. eco : nombre hilo + “INICIO”
2. 50 VECES:
1. contador +1
2. notify()
3. eco : nombre hilo + contador
4. sleep(1000)
3. eco : nombre hilo + “FIN”
hilo2:
1. eco : nombre hilo + “INICIO”
2. MIENTRAS contador <8
1. eco : nombre hilo + contador + “ESPERO”
2. wait()
3. eco : nombre hilo + contador + “FIN
 */
package contador_y_semaforo_metodos;

/**
 *
 * @author juanv
 */
public class Main_Contador_Y_Semaforo {

    public static void main(String[] args) {
       //INSTANCIAMOS RC
       Contador contador=new Contador(0);
       //INTANCIAMOS E INICIALIZAMOS AMBOS HILOS
       Thread_1 hilo1=new Thread_1(contador);
       hilo1.setName("Hilo 1");
       Thread_2 hilo2=new Thread_2(contador);
       hilo2.setName("Hilo 2");
       //ARRANCAMOS HILOS
       hilo1.start();
       hilo2.start();
    }
}

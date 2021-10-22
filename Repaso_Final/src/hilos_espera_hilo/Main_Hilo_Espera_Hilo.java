/*
 Un hilo que espera indefinidamente a otro hilo. En la creación del hilo que
espera se pasará al hilo esperado. En la
carrera del hilo que espera primero obtendrá un número aleatorio, escribirá
su nombre, el número aleatorio y el
nombre del hilo esperado. Luego dormirá durante el tiempo indicado por el
número aleatorio y después esperará
indefinidamente al otro hilo. Cuando finalice la esperá escribirá su nombre
y “FIN”.
El hilo main creará cinco hilos. El hilo1 esperará al hilo2, el hilo2 esperará 
l hilo3, el hilo3 esperará al hilo4, el
hilo4 esperará al hilo5 y el hilo5 esperará al hilo main. Tras crearlos y 
arrancarlos , obtendrá un número aleatorio
y dormirá durante el tiempo indicado por el número aleatorio. Finalmente
escribirá su nombre y “FIN”.

 */
package hilos_espera_hilo;

/**
 *
 * @author juanv
 */
public class Main_Hilo_Espera_Hilo {

    public static void main(String[] args) throws InterruptedException {
        //INSTANCIAMOS E INICIALIZAMOS HILOS
        Thread_Hilo hilo5 = new Thread_Hilo(Thread.currentThread());
        hilo5.setName("Hilo 5");
        Thread_Hilo hilo4 = new Thread_Hilo(hilo5);
        hilo4.setName("Hilo 4");
        Thread_Hilo hilo3 = new Thread_Hilo(hilo4);
        hilo4.setName("Hilo 3");
        Thread_Hilo hilo2 = new Thread_Hilo(hilo3);
        hilo4.setName("Hilo 2");
        Thread_Hilo hilo1 = new Thread_Hilo(hilo2);
        hilo4.setName("Hilo 1");

        //ARRANCAMOS HILOS
        hilo5.start();
        hilo4.start();
        hilo3.start();
        hilo2.start();
        hilo1.start();      
    }
}

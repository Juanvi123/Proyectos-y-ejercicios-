/*
 /*
 El hilo main crea un número aleatorio de coches N(5..10) que circulan hasta que llegan a 
un semáforo. 
cada coche está identificado por un número (1...N).
El semáforo está formado por un número. Inicialmente el número toma un valor aleatorio (1...N)
El número es incrementado circularmente comenzando por un valor inicial aleatorio hasta alcanzar
N y continuar en 1, 2...

Desde que el coche comienza a circular hasta que llega al semáforo tarda un tiempo t(3...17).

Cuando el coche llega al semáforo comprueba si su número identificador coincide con el número
del semáforo, avisa a los coches que están esperando en semáforo para que intenten pasar y finaliza.

Cuando el coche comienza a circular escribirá un mensaje con el nombre del coche, "INICIO",
el instante de tiempo de inicio. El mensaje lo escribirá en pantalla y en un logger de texo.

Cuando espera en el semáforo y levanta una excepción, escribirá un mensaje con el nombre del
coche, "ESPERA en semáforo" y el instante de tiempo en que espera. El mensaje lo escribirá en pantalla
y en un logger de texto. 

Cuando el coche finaliza escribirá un mensaje con el nombre del coche, "FIN", el instante de 
tiempo en que finaliza y el tiempo que ha tardado en finalizar. El mensaje lo escribirá en 
pantalla y en un logger de texto.
 */
package semaforo_coches;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.logging.Logger;

/**
 *
 * @author juanv
 */
public class Main_Semaforo_Coches {

    //CONSTANTES
    private static final int N_MAX_COCHES = 10;
    private static final int N_MIN_COCHES = 5;

    public static void main(String[] args) throws IOException {

        //LOGGER
        Logger logger=Coche.createLogger();
        //CREAMOS EL Nº ALEATORIO DE COCHES
        int nCoches = new Random().nextInt((N_MAX_COCHES - N_MIN_COCHES) + 1) + N_MIN_COCHES;
        System.out.println("Hay " + nCoches + " coches");
        //INSTANCIAMOS RC
        RC_semaforo semaforo = new RC_semaforo(nCoches);
        //INSTANCIAMOS COCHES
        List<Coche> lstCoches = new ArrayList<>();
        for (int i = 0; i < nCoches; i++) {
            lstCoches.add(new Coche(i + 1, semaforo, logger));
            lstCoches.get(i).setName("Coche " + (i + 1));
            lstCoches.get(i).start();
        }
    }

}

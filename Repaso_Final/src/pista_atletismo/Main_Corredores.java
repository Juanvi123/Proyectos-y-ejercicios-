/*
  Un hilo main crea un nº aleatorio de corredores (5...50) que corren en una 
pista de atletismo dando vueltas idefinidamente.
El corredor, en cada vuelta dada, tardará un tiempo aleatorio (15....25). 
Al finalizar la vuelta escribirá un mensaje con el nombre del hilo, el nº de
vueltas que ha dado y el tiemp que ha tardado en correr esa vuelta. El 
mensaje aparecerá en pantalla y en un logger de texto. 

El hilo main después de arrancar los corredores, manda una orden individual para
que se paren; entre una orden y otra, transcurre un tiempo aleatorio (3...11)
y las órdenes se envían aleatoriamente. Todos los corredores han de parar.

Cuando un corredor recibe la orden individual de parada, escribirá un mensaje
con el nombre del hilo, el número de vueltas dadas y el tiempo que ha tardado
en finalizar la carrera. El mensaje aparecerá en pantalla y en el logger.

*AÑADIDO
Sacar el ganador (el q haya dado + vueltas)
 */
package pista_atletismo;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.logging.Logger;

/**
 *
 * @author juanv
 */
public class Main_Corredores {

    //CONSTANTES
    private static final int TIEMPO_MIN_PARADA = 3;
    private static final int TIEMPO_MAX_PARADA = 11;
    private static final int N_MIN_CORREDORES = 99;
    private static final int N_MAX_CORREDORES = 250;

    public static void main(String[] args) throws IOException, InterruptedException {
        //CREAMOS EL LOGGER
        Logger logger = Corredores.createLogger();
        //CREAMOE ALEATORIAMENTE EL Nº DE CORREDORES
        int nCorredores = new Random().nextInt((N_MAX_CORREDORES - N_MIN_CORREDORES) + 1) + N_MIN_CORREDORES;
        System.out.println("Habrá " + nCorredores + " en la pista");
        //INSTANCIAMOS, INICIALIZAMOS Y ARRANCAMOS CORREDORES
        List<Corredores> lstCorredores = new ArrayList<>();
        for (int i = 0; i < nCorredores; i++) {
            lstCorredores.add(new Corredores(logger));
            lstCorredores.get(i).setName("Corredor " + (i + 1));
            lstCorredores.get(i).start();
        }

        //VAMOS PARANDO LOS CORREDORES ALEATORIAMENTE
        int n = 0;
        while (lstCorredores.size() > 0) {
            //TIEMPO HASTA PARADA
            Thread.sleep((new Random().nextInt((TIEMPO_MAX_PARADA - TIEMPO_MIN_PARADA) + 1) + TIEMPO_MIN_PARADA) * 10);
            //COGEMOS ALEATORIAMENTE AL CORREDOR QUE VAMOS A PARAR
            n = new Random().nextInt(lstCorredores.size());
            Corredores corredor = lstCorredores.get(n);
            //INTERRUMPIMOS A ESE CORREDOR 
            corredor.interrupt();
            //ELIMINAMOS A ESE CORREDOR DE LA LISTA
            lstCorredores.remove(corredor);
          
            //GANADOR
            if(lstCorredores.size()==1){
                Thread.sleep(1000);
                System.err.println(lstCorredores.get(0).getName()+" es el campeón, ha dado un total de "+
                        lstCorredores.get(0).getContVueltas()+"vueltas");
            }
        }
        //ESPERAMOS A QUE TODOS LOS HILOS CORREDOR MUERAN
        Thread.sleep(1000);
        //MAIN ECO FINAL
        System.out.println("\n" + Thread.currentThread().getName() + " FIN");
    }

}

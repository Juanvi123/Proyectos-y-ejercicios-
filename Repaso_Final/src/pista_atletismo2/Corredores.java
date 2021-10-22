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
 */
package pista_atletismo2;

import java.io.IOException;
import java.util.Random;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

/**
 *
 * @author juanv
 */
public class Corredores extends Thread {

    //CONSTANTES
    private static final int TIEMPO_MIN = 150;
    private static final int TIEMPO_MAX = 250;

    //VARIABLES
    private int tiempo;
    private int cont;

    //BOOLEANO PARA CONTROLAR LA INTERRUPCIÓN
    private boolean interrupt;

    //Logger
    Logger logger;

    //CONSTRUCTOR
    public Corredores(Logger logger) {
        this.logger = logger;
        this.interrupt = false;
        this.tiempo = 0;
        this.cont = 0;
    }

    //BLOQUE DE EJECUCIÓN
    @Override
    public void run() {

        while (!interrupt) {
            try {
                //TIEMPO QUE TARDA EL CORREDOR EN DAR LA VUELTA
                tiempo = new Random().nextInt((TIEMPO_MAX - TIEMPO_MIN) + 1) + TIEMPO_MIN;
                this.sleep(tiempo);
                //INCREMENTAMOS EL CONTADOR
                cont++;
                //ECO
                System.out.println(getName() + " ha tardado " + tiempo + " min en dar"
                        + " la vuelta " + cont);
                logger.log(Level.INFO, getName() + " ha tardado " + tiempo + " min en dar"
                        + " la vuelta " + cont);
            } catch (InterruptedException ex) {
                //CAMBIAMOS EL VALOR DEL BOOLEANO PARA SALIR DEL BUCLE
                interrupt = true;
                //ECOS FINALES
                if (cont == 1) {
                    System.out.println(getName() + " FIN. Ha dado solo " + cont + " vuelta en total");
                    logger.log(Level.INFO, getName() + " FIN. Ha dado solo " + cont + " vuelta en total");
                } else {
                    System.out.println(getName() + " FIN. Ha dado " + cont + " vueltas en total");
                    logger.log(Level.INFO, getName() + " FIN. Ha dado " + cont + " vueltas en total");
                }
            }
        }

    }

    /**
     * Método con el que crearemos el fichero del logger
     *
     * @return
     * @throws IOException
     */
    public static Logger createLogger() throws IOException {
        Logger logger = Logger.getLogger("Ejercio");
        FileHandler fh = new FileHandler("Pista_Atletismo_2.log", true);
        logger.addHandler(fh);
        SimpleFormatter sf = new SimpleFormatter();
        fh.setFormatter(sf);
        return logger;
    }

    //GETTER
    public int getCont() {
        return cont;
    }

}

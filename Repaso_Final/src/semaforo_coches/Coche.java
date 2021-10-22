/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package semaforo_coches;

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
public class Coche extends Thread {

    //CONSTANTES
    private static final int TIEMPO_MIN = 3;
    private static final int TIEMPO_MAX = 17;

    //DECLARAMOS VARIABLES
    private int n;
    private int tiempo;
    private int cont;

    //INSTANCIA RC
    RC_semaforo semaforo;

    //LOGGER
    private Logger logger;
    

    //CONSTRUCTOR
    public Coche(int n, RC_semaforo semaforo,Logger logger) {
        this.n = n;
        this.semaforo = semaforo;
        this.tiempo = 0;
        this.logger=logger;
    }

    //BLOQUE DE EJECUCIÓN
    @Override
    public void run() {

        //ECO INICIAL COCHE
        tiempo = new Random().nextInt((TIEMPO_MAX - TIEMPO_MIN) + 1) + TIEMPO_MIN;
        System.out.println(getName() + " INICIO, tarda " + tiempo + "min en llegar al semáforo");
        logger.log(Level.INFO, getName() + " INICIO, tarda " + tiempo + "min en llegar al semáforo");
        try {
            //TIEMPO HASTA LLEGAR A SEMÁFORO
            this.sleep(tiempo * 100);
            synchronized (semaforo) {
            if (getN() != semaforo.getN()) {
                    // System.out.println("Valor semaforo: "+semaforo.getN());
                    System.out.println(getName() + " espera en semáforo");
                    logger.log(Level.INFO,getName() + " espera en semáforo");
                    while (getN() != semaforo.getN()) {
                        semaforo.wait();
                        cont++;
                    }
                }
                System.out.println(getName() + " FIN, instante en finalizar " + (cont+tiempo));
                logger.log(Level.INFO,getName() + " FIN, instante en finalizar " + (cont+tiempo));
                //CAMBIAMOS VALOR DEL SEMÁFORO
                semaforo.setN();
                semaforo.notifyAll();
            }

        } catch (InterruptedException ex) {
        }

    }

    //GETTER
    public int getN() {
        return n;
    }
    
    /**
     * Método con el creamos el fichero .log
     * @return
     * @throws IOException 
     */
    public static Logger createLogger() throws IOException{
        Logger logger=Logger.getLogger("Logger ejercicio");
        FileHandler fh=new FileHandler("Semaforo_Coches.log", true);
        logger.addHandler(fh);
        SimpleFormatter sf=new SimpleFormatter();
        fh.setFormatter(sf);
        return logger;
    }

}

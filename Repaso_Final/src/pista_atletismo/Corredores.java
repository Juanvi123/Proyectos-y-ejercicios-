/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pista_atletismo;

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
    private static final int TIEMPO_MIN = 15;
    private static final int TIEMPO_MAX = 25;

    //VARIABLES
    private int tiempo;
    private int contVueltas;
    private Logger logger;
    private boolean interrupt;//true INTERRUMPIDO false NO INTERRUMPIDO

    //CONSTRUCTOR
    public Corredores(Logger logger) {
        this.logger = logger;
        this.interrupt = false;
    }

    //BLOQUE DE EJECUCIÓN
    @Override
    public void run() {
        try {
            while (!interrupt) {

                //TIEMPO QUE TARDA EN DAR LA VUELTA
                tiempo = new Random().nextInt((TIEMPO_MAX - TIEMPO_MIN)) + TIEMPO_MIN;
                this.sleep(tiempo * 10);
                //INCREMENTAMOS CONTADOR DE VUELTAS
                contVueltas++;
                //ECO
                System.out.println(getName() + " ha dado la vuelta " + contVueltas
                        + " en " + tiempo + " min");
                logger.log(Level.INFO, getName() + " ha dado la vuelta " + contVueltas
                        + " en " + tiempo + " min");
            }
        } catch (InterruptedException ex) {
            //CAMBIAMOS EL VALOR DEL SEMÁFORO A TRUE
            interrupt = true;
            //ECOS FINALES DE DICHO HILO
            System.out.println(getName() + " finaliza, ha dado un total de " + contVueltas + ""
                    + " vueltas");
            logger.log(Level.INFO, getName() + " ha dado la vuelta " + contVueltas
                    + " en " + tiempo + " min");
        }
    }

    //CREAMOS LA CLASE ESTÁTICA QUE VA A CREAR NUESTRO FICHERO .LOG
    public static Logger createLogger() throws IOException {
        Logger logger = Logger.getLogger("Ejercicio de corredores");
        FileHandler fh = new FileHandler("Pista_Atletismo_Repaso_Final.log", true);
        logger.addHandler(fh);
        SimpleFormatter sf = new SimpleFormatter();
        fh.setFormatter(sf);
        return logger;
    }
    
    //GETTERS
    public int getContVueltas() {
        return contVueltas;
    }
    

}

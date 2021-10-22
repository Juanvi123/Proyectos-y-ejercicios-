/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tcp_udp_servidor_tcp_puerto_variable;

import java.io.IOException;
import java.util.Random;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author juanv
 */
public class Cambiar_Puerto extends TimerTask {
//CONSTANTES
    private static final int PUERTO_MIN=12333;
    private static final int PUERTO_MAX=55688;
    //BLOQUE DE EJECUCIÓN
    @Override
    public void run() {
        try {
            //CREAMOS EL NUEVO PUERTO ALEATORIAMENTE
            int puertoAle=new Random().nextInt((PUERTO_MAX-PUERTO_MIN)+1)+PUERTO_MIN;
            //PASAMOS EL PUERTO AL SERVIDOR
            Servidor.setPuerto(puertoAle);
        } catch (IOException ex) {
            Logger.getLogger(Cambiar_Puerto.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}

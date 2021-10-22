/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package udp_reloj_broadcast;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author juanv
 */
public class Thread_Paisano extends Thread {

    //DECLARAMOS VARIABLES
    private byte[] buffer;
    private DatagramPacket dgpRecibir;
    private DatagramSocket socket;
    private String horaActual;

    //CONSTRUCTOR
    public Thread_Paisano(byte[] buffer, DatagramPacket dgpRecibir, DatagramSocket socket, String horaActual) {
        this.buffer = buffer;
        this.dgpRecibir = dgpRecibir;
        this.socket = socket;
        this.horaActual = horaActual;
    }

    //BLOQUE DE EJECUCIÓN
    @Override
    public void run() {
        try {
           for(int i=0;i<5;i++) {
                //TRATAMIENTO DE DATOS
                this.sleep(1000);
                ObjectInputStream ois = new ObjectInputStream(new ByteArrayInputStream(buffer));
                horaActual = ois.readObject().toString();
                System.out.println(getName()+"recibe hora actual: " + horaActual);
            }

        } catch (IOException ex) {
            Logger.getLogger(Thread_Paisano.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Thread_Paisano.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InterruptedException ex) {
            Logger.getLogger(Thread_Paisano.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}

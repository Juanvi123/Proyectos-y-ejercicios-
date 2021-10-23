/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tcp_cliente_multihilo_servidor_multihilo;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author juanv
 */
public class Thread_Servidor extends Thread {

    //CONSTANTES
    private static final int ESPERA = 100;

    //CLIENTE
    Socket socket;

    //FLUJOS
    DataInputStream flujoEntrada;
    DataOutputStream flujoSalida;

    //VARIABLES
    private String mensajeEntrada;
    private String mensajeSalida;
    private int i;

    //CONSTRUCTOR
    public Thread_Servidor(Socket socket) throws IOException {
        this.socket = socket;
        this.flujoEntrada = new DataInputStream(socket.getInputStream());
        this.flujoSalida = new DataOutputStream(socket.getOutputStream());
        this.mensajeEntrada = "";
        this.mensajeSalida="";
        this.i=0;
    }

    //BLOQUE DE EJECUCIÓN
    @Override
    public void run() {
        try {
            //MIENTRAS EL MENSAJE DEL HILO CLIENTE NO SEA FIN
            while (!mensajeEntrada.trim().toUpperCase().equals("FIN")) {
                //ESPERA MENSAJE DEL CLIENTE
                this.sleep(ESPERA);
                mensajeEntrada=flujoEntrada.readUTF();
                //ECO
                System.out.println(mensajeEntrada);
                //MANDA MENSAJE A HILO CLIENTE
                mensajeSalida=getName()+" manda mensaje "+(i+1)+" a Hilo Cliente ";
                flujoSalida.writeUTF(mensajeSalida);
            }
            //LIBERAMOS RECURSOS
            System.out.println(getName()+" FIN");
            flujoEntrada.close();
            flujoSalida.close();
            socket.close();
        } catch (InterruptedException ex) {
            Logger.getLogger(Thread_Servidor.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Thread_Servidor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}

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
public class Thread_Cliente extends Thread {

    //CONSTANTES
    private static final int N = 20;
    private static final int ESPERA = 300;

    //SOCKET
    private Socket socket;

    //FLUJOS
    private DataInputStream flujoEntrada;
    private DataOutputStream flujoSalida;

    //VARIABLES
    private String mensajeEntrada;
    private String mensajeSalida;

    //CONSTRUCTOR
    public Thread_Cliente(Socket socket) throws IOException {
        this.socket = socket;
        this.flujoEntrada = new DataInputStream(socket.getInputStream());
        this.flujoSalida = new DataOutputStream(socket.getOutputStream());
        this.mensajeEntrada = "";
        this.mensajeSalida = "";
    }

    //BLOQUE DE EJECUCIÓN
    @Override
    public void run() {
        try {
            for (int i = 0; i <N; i++) {
                //ENVIA MENSAJE A HILO SERVIDOR
                mensajeSalida = getName() + " envía mensaje "+(i+1)+" a hilo servidor";
                flujoSalida.writeUTF(mensajeSalida);
                //ESPERA MENSAJE RESPUESTA
                this.sleep(ESPERA);
                //MENSAJE RESPUESTA
                mensajeEntrada = flujoEntrada.readUTF();
                //ECO MENSAJE ENTRADA
                System.out.println(mensajeEntrada);

            }
            //ENVIA MENSAJE FINAL A HILO SERVIDOR
            mensajeSalida = "FIN";
            flujoSalida.writeUTF(mensajeSalida);
            //ECO
            System.out.println(getName() + " envía FIN");
            //CERRAMOS SOCKET
            socket.close();
        } catch (IOException ex) {
            Logger.getLogger(Thread_Cliente.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InterruptedException ex) {
            Logger.getLogger(Thread_Cliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}

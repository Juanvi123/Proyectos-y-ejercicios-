/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tcp_4_03_09_tcp_cliente_servidor_multihilo;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author juanv
 */
public class Hilo_Escuha extends Thread {

    //CONSTANTES
    private static final int TAMANO_RC = 25;

    //SERVER SOCKET
    ServerSocket serverSocket;

    //SOCKET
    Socket socket;
    //RC
    LinkedBlockingQueue<Socket_Identificador> socketCola;

    //VARIABLES
    private String mensajeEntrada;
    private String mensajeSalida;

    //FLUJOS
    DataInputStream flujoEntrada;
    DataOutputStream flujoSalida;

    private int cont;
    //CONSTRUCTOR
    public Hilo_Escuha(ServerSocket serverSocket, LinkedBlockingQueue<Socket_Identificador> socketCola) {
        this.serverSocket = serverSocket;
        this.socketCola = socketCola;
        this.mensajeEntrada = "";
        this.mensajeSalida = "";
        this.cont=0;
    }

    //BLOQUE DE EJECUCIÓN
    @Override
    public void run() {
        try {
            //INFINITAS VECES
            while (true) {
                //ACEPTAMOS CONEXIÓN
                socket = serverSocket.accept();
                //ESPERA MENSAJE CLIENTE
                flujoEntrada = new DataInputStream(socket.getInputStream());
                mensajeEntrada = flujoEntrada.readUTF();
                //INCREMENTAMOS CONTADOR
                cont ++;
                //COMPROBAMOS EL Nº DE CLIENTES QUE HAY EN RC
                if (socketCola.size() < TAMANO_RC) {
                    //INICIALIZAMOS EL OBJETO DONDE GUARDAMOS EL SOCKET Y SU IDENTIFICADOR
                    Socket_Identificador socket_Identificador = new Socket_Identificador(socket, mensajeEntrada);
                    //METEMOS SOCKET EN RC
                    socketCola.put(socket_Identificador);

                } else {
                    mensajeSalida = getName() + " no atiende a " + mensajeEntrada;
                    //INICIALIZAMOS FLUJO SALIDA
                    flujoSalida = new DataOutputStream(socket.getOutputStream());
                    //ENVIAMOS MENSAJE DE SALIDA A CLIENTE
                    flujoSalida.writeUTF(mensajeSalida);
                    //CERRAMOS SOCKET
                    socket.close();
                }
               
            }
        } catch (IOException ex) {
            Logger.getLogger(Hilo_Escuha.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InterruptedException ex) {
            Logger.getLogger(Hilo_Escuha.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}

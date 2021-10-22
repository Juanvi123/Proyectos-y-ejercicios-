/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tcp_4_03_11_tcp_cliente_servidor_multihilo;

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
public class Hilo_Escucha extends Thread {

    //CONSTANTES
    private static final int PUERTO = 5555;
    private static final int M_Hilos = 10;

    //SERVIDOR
    ServerSocket serverSocket;

    //CLIENTES
    Socket socket;

    //RC
    LinkedBlockingQueue<Hilo_Atencion_Cliente> socketCola;

    //FLUJOS
    DataInputStream flujoEntrada;
    DataOutputStream flujoSalida;

    //VARIABLES
    private int nCliente;
    private int maxClientes;

    //CONTRUCTOR
    public Hilo_Escucha(ServerSocket serverSocket, LinkedBlockingQueue<Hilo_Atencion_Cliente> socketCola,
            int maxClientes) {
        this.serverSocket = serverSocket;
        this.socketCola = socketCola;
        this.maxClientes=maxClientes;
        
    }

    //BLOQUE DE EJECUCIÓN
    @Override
    public void run() {
        try {
            
            //INFINITAS VECES
            while (true) {

                //ACEPTA CONEXIÓN DE CLIENTE
                socket = serverSocket.accept();
                //INICIALIZAMOS FLUJOS
                flujoEntrada = new DataInputStream(socket.getInputStream());
                flujoSalida = new DataOutputStream(socket.getOutputStream());
                flujoSalida.writeInt(maxClientes);
                //INCREMENTAMOS CONTADOR DE CLIENTES
                nCliente++;
                //SI HAY M HILOS VIVOS EN RC
                if (socketCola.size() == M_Hilos) {
                    flujoSalida.writeUTF(getName() + " no atiende a Cliente " + nCliente);
                    //CIERRA CONEXIÓN
                    socket.close();
                    System.out.println(getName() + " rechaza conexión con cliente " + nCliente);
                    if (nCliente == maxClientes) {
                        System.out.println("FIN del programa");
                        break;
                    }
                }//SI NO HAY M HILOS VIVOS EN RC
                else {
                    //CREAMOS HILO ATENCION AL CLIENTE
                    System.out.println(getName() + " acepta conexión con cliente " + nCliente);
                    Socket_Identificador socket_Identificador = new Socket_Identificador(socket, nCliente);
                    Hilo_Atencion_Cliente hilo_Atencion_Cliente = new Hilo_Atencion_Cliente(socket_Identificador);
                    socketCola.put(hilo_Atencion_Cliente);
                    hilo_Atencion_Cliente.start();
                    //METEMOS HILO EN RC

                }

            }
        } catch (IOException ex) {
            Logger.getLogger(Hilo_Escucha.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InterruptedException ex) {
            Logger.getLogger(Hilo_Escucha.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tcp_extremos_bidireccionales_hilos;

import tcp_extremos_bidireccionales.*;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 *
 * @author juanv
 */
public class Servidor {

    //CONSTANTES
    private static final int PUERTO = 5555;
    private static final int MAX_CLIENTES = 3;

    //SERVIDOR
    ServerSocket serverSocket;

    //SERVIDOR 
    Socket socket;

    //FLUJOS DE ENTRADA Y SALIDA
    DataInputStream flujoEntrada;
    DataOutputStream flujoSalida;

    //VARIABLES
    List<Thread_Servidor> lstClientes;

    public Servidor() throws IOException {
        this.serverSocket = new ServerSocket(PUERTO);
        this.lstClientes = new ArrayList<>(MAX_CLIENTES);
        System.out.println("Servidor espera nº de clientes");

    }

    public void tratamientoInformacion() throws IOException, InterruptedException {

        //BUCLE INFINITO
        for (int i = 0; true; i++) {
            if (lstClientes.size() < MAX_CLIENTES) {
                //ACEPTAMOS CONEXIÓN
                socket = serverSocket.accept();
                System.out.println("ddkd");
                //CREAMOS HILOS
                lstClientes.add(new Thread_Servidor(socket));
                lstClientes.get(i).setName("Cliente " + (i + 1));
                lstClientes.get(i).start();
            } else {
                //ESPERAMOS A QUE MUERAN LOS HILOS
                for (int j = 0; j < MAX_CLIENTES; j++) {
                    lstClientes.get(j).join();
                }
                for (int j = 0; j < MAX_CLIENTES; j++) {
                    while (lstClientes.get(j).isAlive()) {
                        Thread.sleep(10);
                    }
                }
                System.out.println("FIN del programa");
                break;
            }
        }
    }

    //MAIN
    public static void main(String[] args) throws IOException, InterruptedException {
        try {
            Servidor servidor = new Servidor();
            servidor.tratamientoInformacion();
        } catch (SocketException se) {
            System.out.println("FIN del programa");
        }

    }

}

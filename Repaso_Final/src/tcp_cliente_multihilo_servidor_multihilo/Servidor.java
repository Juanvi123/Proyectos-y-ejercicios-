/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tcp_cliente_multihilo_servidor_multihilo;

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

    //SERVIDOR
    ServerSocket serverSocket;

    //CLIENTE
    Socket socket;

    //FLUJO
    DataOutputStream flujoSalida;

    //VARIABLES
    private String mensajeSalida;

    //CONTENEDOR DE HILOS
    List<Thread_Servidor> lstThread_Servidors;

    //CONSTRUCTOR
    public Servidor() throws IOException {
        this.serverSocket = new ServerSocket(PUERTO);
        this.mensajeSalida = "";
        this.lstThread_Servidors = new ArrayList<>();
        //ECO INICIAL
        System.out.println("Servidor abierto, escucho por puerto "+serverSocket.getLocalPort());
    }

    public void tratamientoInformacion() throws IOException, InterruptedException {
        //SIEMPRE
        for (int i = 0; true; i++) {
            //ACEPTA CONEXION
            socket = serverSocket.accept();
            flujoSalida = new DataOutputStream(socket.getOutputStream());
            //ENVIA MENSAJE RESPUESTA
            mensajeSalida = "Establecemos conexión con Cliente " + (i + 1);
            flujoSalida.writeUTF(mensajeSalida);
            //CREA HILO SERVIDOR
            lstThread_Servidors.add(new Thread_Servidor(socket));
            lstThread_Servidors.get(i).setName("Hilo_Servidor " + (i + 1));
            lstThread_Servidors.get(i).start();
            lstThread_Servidors.get(i).join();
        }
    }

    //MAIN
    public static void main(String[] args) throws IOException, InterruptedException {
        Servidor servidor = new Servidor();
        servidor.tratamientoInformacion();
    }

}

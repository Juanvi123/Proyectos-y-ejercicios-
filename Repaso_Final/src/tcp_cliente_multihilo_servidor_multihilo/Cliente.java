/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tcp_cliente_multihilo_servidor_multihilo;

import java.io.DataInputStream;
import java.io.DataOutput;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Random;

/**
 *
 * @author juanv
 */
public class Cliente {

    //CONSTANTES
    private static final int PUERTO = 5555;
    private static final String IP = "localhost";

    //SOCKET
    Socket socket;

    //FLUJOS
    DataInputStream flujoEntrada;
    DataOutputStream flujoSalida;

    //VARIABLES
    private String mensajeEntrada;

    public Cliente() throws UnknownHostException, IOException {
        //INICIALIZAMOS VARIABLES
        this.mensajeEntrada = "";
    }

    //MÉTODOS
    public void tratamientoDatos() throws IOException, InterruptedException {
        //Nº HILOS
        for (int i = 0; i < 5; i++) {
            //ECO INICIAL
            System.out.println("Inicio Cliente "+(i+1));
            //ABRE CONEXIÓN TCP CON SERVIDOR MULTIHILO
            this.socket = new Socket(InetAddress.getByName(IP), PUERTO);
            this.flujoEntrada = new DataInputStream(socket.getInputStream());
            //ESPERA MENSAJE RESPUESTA
            Thread.sleep(3000);
            mensajeEntrada = flujoEntrada.readUTF();
            //ECO MENSAJE ENTRADA
            System.out.println(mensajeEntrada);
            //CREA HILO CLIENTE
            Thread_Cliente thread_Cliente = new Thread_Cliente(socket);
            thread_Cliente.setName("Hilo_Cliente " + (i + 1));
            thread_Cliente.start();
            thread_Cliente.join();

        }

    }

    //MAIN
    public static void main(String[] args) throws InterruptedException, IOException {
        try {
            Cliente cliente = new Cliente();
            cliente.tratamientoDatos();

        } catch (SocketException se) {
            System.err.println("FIN del programa");
        }

    }
}

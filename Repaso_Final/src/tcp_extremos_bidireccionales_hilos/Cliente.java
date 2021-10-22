/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tcp_extremos_bidireccionales_hilos;

import tcp_extremos_bidireccionales.*;
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
    private static final int N_MAX = 10;
    private static final int N_MIN = 1;

    //SOCKET
    Socket socket;

    //FLUJOS
    DataInputStream flujoEntrada;
    DataOutputStream flujoSalida;

    //VARIABLES
    private int n;
    private int suma;

    public Cliente() throws UnknownHostException, IOException {
        //INICIALIZAMOS VARIABLES
        this.socket = new Socket(InetAddress.getByName(IP), PUERTO);
        this.suma = 0;
        this.n = 0;
  
        Thread_Cliente hiloCliente=new Thread_Cliente(socket);
        hiloCliente.setName("Cliente ");
        hiloCliente.start();
    }
    
    //MAIN
    public static void main(String[] args) throws InterruptedException, IOException {
        try {
           Cliente cliente = new Cliente();
        } catch (SocketException se) {
            System.err.println("FIN del programa");
        }

    }
}

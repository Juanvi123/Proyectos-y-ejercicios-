/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tcp_4_03_04_clienteTCP_multihlo;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.SocketException;
import java.net.UnknownHostException;

/**
 *
 * @author juanv
 */
public class Cliente {

    //CONSTANTES
    private static final int PUERTO = 5555;
    private static final String IP = "localhost";
    private static final int ESPERA = 5000;

    //SOCKET
    Socket socket;

    //FLUJOS
    DataInputStream flujoEntrada;
    DataOutputStream flujoSalida;

    //VARIABLES 
    private String mensajeEntrada;
    private String mensajeSalida;
    private int contador;

    public Cliente() throws UnknownHostException, IOException {
        this.socket = new Socket(InetAddress.getByName(IP), PUERTO);
        this.flujoEntrada = new DataInputStream(socket.getInputStream());
        this.flujoSalida = new DataOutputStream(socket.getOutputStream());
        this.mensajeEntrada = "";
        this.mensajeSalida = "Hola servidor";
        this.contador = 0;
    }

    public void tratamientoDatos() throws IOException, InterruptedException {
        try {
            mensajeEntrada = flujoEntrada.readUTF();
            while (mensajeEntrada.trim().toUpperCase().equals("HOLA")) {
                System.out.println("Servidor manda " + mensajeEntrada);
                //ESPERA
                Thread.sleep(ESPERA);
                //REINTENTO DE CONEXIÓN
                System.out.println("reintentamos conexión");
                this.socket = new Socket(InetAddress.getByName(IP), PUERTO);
                //CLIENTE MANDA 
                flujoSalida.writeUTF(mensajeSalida);
                System.out.println("Cliente manda a servidor: " + mensajeSalida);
            }
            System.out.println("Conexión conseguida");
            while (!mensajeEntrada.trim().toUpperCase().equals("ADIOS")) {
                if (contador < 10) {
                    //TIEMPO ENTRE MENSAJES
                    Thread.sleep(1000);
                    //CLIENTE MANDA MENSAJE
                    flujoSalida.writeUTF(mensajeSalida);
                    System.out.println("Cliente manda a servidor: " + mensajeSalida);
                    //CLIENTE RECIBE MENSAJE
                    mensajeEntrada = flujoEntrada.readUTF();
                    System.out.println("Mensaje del Servidor: " + mensajeEntrada);
                    contador++;
                } else {
                    //TIEMPO ENTRE TANDAS DE MENSAJES
                    Thread.sleep(1000);
                    mensajeSalida = "ADIOS";
                    //CLIENTE MANDA MENSAJE
                    flujoSalida.writeUTF(mensajeSalida);
                    System.out.println("Cliente manda a servidor: " + mensajeSalida);
                    //CLIENTE RECIBE MENSAJE
                    mensajeEntrada = flujoEntrada.readUTF();
                    System.out.println("Mensaje del Servidor: " + mensajeEntrada);
                }

            }
        } catch (SocketException se) {
            System.err.println("Fin de conexión");
        }

    }

    public static void main(String[] args) throws IOException, InterruptedException {
        Cliente cliente = new Cliente();
        cliente.tratamientoDatos();
    }

}

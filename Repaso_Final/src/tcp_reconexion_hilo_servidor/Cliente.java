/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tcp_reconexion_hilo_servidor;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 *
 * @author juanv
 */
public class Cliente {

    //CONSTANTES
    private static final int PUERTO_SERVIDOR = 5555;
    private static final int PUERTO_HILO_SERVIDOR = 5556;
    private static final String IP = "localhost";
    private static final int ESPERA = 1000;
    private static final int BUCLE = 20;

    //SOCKET
    Socket socket;

    //FLUJOS
    DataInputStream flujoEntrada;
    DataOutputStream flujoSalida;

    //VARIABLES
    private String mensajeEntrada;
    private String mensajeSalida;
    private int contador;

    //CONSTRUCTOR
    public Cliente() throws UnknownHostException, IOException {
        //INICIALIZAMOS ELEMENTOS
        //ABRIMOS CONEXIÓN CON SERVIDOR MULTIHILO
        this.socket = new Socket(InetAddress.getByName(IP), PUERTO_SERVIDOR);
        this.flujoEntrada = new DataInputStream(socket.getInputStream());
        this.flujoSalida = new DataOutputStream(socket.getOutputStream());
        this.mensajeEntrada = "";
        this.mensajeSalida = "";
        this.contador = 0;
    }

    public void mensajeRespuestaServidor() throws IOException {
        mensajeEntrada = flujoEntrada.readUTF();
        System.out.println("Mensaje servidor: " + mensajeEntrada);
    }

    public void conexionHiloServidor() throws UnknownHostException, IOException, InterruptedException {
        //VOLVEMOS A INICIALIZAR SOCKET CLIENTE
        socket = new Socket(InetAddress.getByName(IP), PUERTO_HILO_SERVIDOR);
        //VOLVEMOS A INICIALIZAR FLUJOS
        this.flujoEntrada = new DataInputStream(socket.getInputStream());
        this.flujoSalida = new DataOutputStream(socket.getOutputStream());
        for (int i = 0; i < BUCLE; i++) {
            //ESPERA MENSAJE
            Thread.sleep(ESPERA);
            //RECIBE MENSAJE DE HILO SERVIDOR
            mensajeEntrada = flujoEntrada.readUTF();
            //ECO
            System.out.println("Cliente recibe: " + mensajeEntrada);
            //MANDA MENSAJE
            mensajeSalida = "Servidor, esta es la iteración "+(i+1);
            flujoSalida.writeUTF(mensajeSalida);
            //INCREMENTAMOS CONTADOR
            contador++;
        }
        //ESPERA MENSAJE
        Thread.sleep(ESPERA);
        //RECIBE MENSAJE DE HILO SERVIDOR
        mensajeEntrada = flujoEntrada.readUTF();
        //ECO
        System.out.println("Cliente recibe: " + mensajeEntrada);
        //MANDA MENSAJE
        mensajeSalida = "FIN";
        flujoSalida.writeUTF(mensajeSalida);
    }

    //MAIN
    public static void main(String[] args) throws IOException, UnknownHostException, InterruptedException {
        Cliente cliente = new Cliente();
        cliente.mensajeRespuestaServidor();
        cliente.conexionHiloServidor();
    }

}

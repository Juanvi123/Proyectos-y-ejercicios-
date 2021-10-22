/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tcp_udp_servidor_tcp_puerto_variable;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.Socket;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author juanv
 */
public class Cliente {

    //CONSTANTES
    private static final int PUERTO_CLIENTE_UDP = 5556;
    private static final int PUERTO_SERVIDOR_UDP = 2525;
    private static final String IP = "localhost";
    private static final int MAX_TAMANO_BUFFER = 3000;
    private static final int ESPERA = 1000;

    //VARIABLES UDP
    //BUFFER
    byte[] buffer;

    //DATAGRAMPACKET
    DatagramPacket dgpEnviar;
    DatagramPacket dgpRecibir;

    //SOCKET UDP
    DatagramSocket socketUDP;

//VARIABLES TCP
    //SOCKET
    Socket socket;

    //FLUJOS
    DataInputStream flujoEntrada;
    DataOutputStream flujoSalida;

    //VARIABLES
    private int puertoTCP;
    private String mensajeEntrada;
    private String mensajeSalida;
    private int contador;

    //CONSTRUCTOR
    public Cliente() throws UnknownHostException, SocketException {
        this.socketUDP = new DatagramSocket(PUERTO_CLIENTE_UDP);
        this.buffer = new byte[MAX_TAMANO_BUFFER];
        this.puertoTCP = 0;
        this.contador = 0;
        this.mensajeSalida = "";
        this.mensajeEntrada = "";

    }

    public void recibirMensajeUDP() throws IOException, ClassNotFoundException {
        //INICIALIZAMOS EL buffer
        buffer = new byte[MAX_TAMANO_BUFFER];
        //INICIALIZAMOS EL DGP
        dgpRecibir = new DatagramPacket(buffer, buffer.length);
        //RECIBIMOS MENSAJE
        socketUDP.receive(dgpRecibir);
        //TRATAMIENTO DE LA INFORMACIÓN
        ObjectInputStream ois = new ObjectInputStream(new ByteArrayInputStream(buffer));
        puertoTCP = Integer.parseInt(ois.readObject().toString());
        //ECO
        System.out.println("Puerto TCP: " + puertoTCP);
        //CERRAMOS SOCKET
        socketUDP.close();
    }

    public void enviarMensajeUDP() throws IOException {
        //INICIALIZAR BUFFER
        buffer = new byte[MAX_TAMANO_BUFFER];
        int mensaje = PUERTO_CLIENTE_UDP;
        //TRATAMIENTO DEL MENSAJE
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(baos);
        oos.writeObject(mensaje);
        buffer = baos.toByteArray();
        //INICIALIZAMOS DGP ENVIO
        dgpEnviar = new DatagramPacket(buffer, buffer.length,
                InetAddress.getByName(IP), PUERTO_SERVIDOR_UDP);
        //ENVIAMOS EL PAQUETE
        socketUDP.send(dgpEnviar);

    }

    public void hiloCliente(String nombre) throws UnknownHostException, IOException {
        Hilo_Cliente hilo_Cliente = new Hilo_Cliente(socket, puertoTCP);
        hilo_Cliente.setName(nombre);
        hilo_Cliente.start();
    }

    //MAIN
    public static void main(String[] args) throws UnknownHostException, SocketException,
            IOException, ClassNotFoundException {
        Cliente cliente = new Cliente();
        cliente.enviarMensajeUDP();
        cliente.recibirMensajeUDP();
        for (int i = 0; i < 50; i++) {
            cliente.hiloCliente("Cliente "+(i+1));
        }

    }

}

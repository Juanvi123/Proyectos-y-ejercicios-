/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package udp_reloj_broadcast;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

/**
 *
 * @author juanv
 */
public class Paisano {

    //CONSTANTES
    private static final String IP = "192.168.56.255";
    private static final int PUERTO_RELOJ = 5555;
    private static final int PUERTO_PAISANO = 5556;
    private static final int MAXIMO_TAMANO_BUFFER = 3000;

    //BUFFER
    byte[] buffer;

    //DATAGRAMPACKAGE
    DatagramPacket dgpRecibir;

    //SOCKET
    DatagramSocket socket;

    //VARIABLES
    private String horaActual;

    //CONSTRUCTOR
    public Paisano() throws SocketException {
        //INICIALIZAMOS PARÁMETROS
        this.buffer = new byte[MAXIMO_TAMANO_BUFFER];
        this.horaActual = "";
        this.socket = new DatagramSocket(PUERTO_PAISANO);
        socket.setBroadcast(true);

    }

    //MÉTODOS
    public void recibirMensaje() throws IOException, ClassNotFoundException {
        for (int i = 0; true; i++) {
            //ECO INICIAL
            System.out.println(getClass().getSimpleName() + " espera hora");
            //RECIBIENDO EL MENSAJE
            dgpRecibir = new DatagramPacket(buffer, buffer.length);
            socket.receive(dgpRecibir);
            Thread_Paisano thread_Paisano = new Thread_Paisano(buffer, dgpRecibir, socket, IP);
            thread_Paisano.setName("Paisano " + (i + 1));
            thread_Paisano.start();
        }

    }

    //MAIN
    public static void main(String[] args) throws SocketException, IOException, ClassNotFoundException {
        Paisano paisano = new Paisano();

        paisano.recibirMensaje();
    }

}
